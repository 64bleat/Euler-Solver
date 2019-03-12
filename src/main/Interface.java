package main;

import java.util.*;
import java.awt.Desktop;
import java.net.URI;

import problems.*;
import supplemental.*;

public class Interface
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    FileLoader fl = new FileLoader();
    List<String> answers = fl.loadTextFile("/files/Answers.txt");
    List<String> times= fl.loadTextFile("/files/Times.txt");
    
    System.out.println("===Project Euler Solver===\nInclude \"link\" to load the problem's webpage\nType \"exit\" to... exit.\n==========================");

    while(true)
    {
      String input;
      
      System.out.print("Which problem would you like to solve? ");
      input = in.nextLine().toUpperCase();
      
      if(input.equals("EXIT"))
      {
        System.out.println("Exiting.");
        in.close();
        return;
      }
      else
      {
        P_0 problem = null;
        boolean openLinks = false;

        if(input.contains("LINK"))
        {
          input = input.replace("LINK",  "");
          input = input.replace(" ",  "");
          openLinks = true;
        }
           
        // Add Trailing 0's
        while(input.length() < 3)
          input = "0" + input;

        //Load Problem
        try{problem = (P_0)Class.forName("problems.P_" + input).newInstance();}
        catch(Exception e) {System.out.print("invalid input. ");}
        
        if(problem != null)
        {
          int i = Integer.parseInt(input);
          long startTime = System.currentTimeMillis();
          long answer = problem.run();
          long newTime = System.currentTimeMillis() - startTime;
          
          //open links
          if (openLinks && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE))
            try
            {
              Desktop.getDesktop().browse(new URI("https://projecteuler.net/problem=" + Integer.parseInt(input)));
              Desktop.getDesktop().browse(new URI("https://github.com/64bleat/EulerSolutions-Java/blob/master/src/problems/P_" + input +".java"));
            }
            catch (Exception e){/*no need to do anything, just keep going*/}
          
          //add blank lines for unanswered questions.
          while(answers.size() <= i) answers.add("");
          while(times.size() <= i) times.add("");
          
          System.out.println("Output for " + input + ": " + answer + " (" + newTime + "ms)");
          
          // NEW ANSWER
          if(answers.get(i).isEmpty())
          {
            String inquiry = "";
            
            System.out.print("No answer recorded. Is this correct? ");
            inquiry = in.nextLine().toUpperCase();
            
            if(inquiry.equals("YES"))
              answers.set(i, ""+answer);
            
            fl.saveTextFile("/files/Answers.txt", answers);
          }
          else if(Long.parseLong(answers.get(i)) != answer) //wrong answer
            System.out.println("WRONG!!! CORRECT ANSWER IS " + answers.get(i) + " !!!");
          
          // TIME HANDLING
          if(!answers.get(i).isEmpty() && answer == Long.parseLong(answers.get(i)))
          {
            if(times.get(i).isEmpty())
            {
              System.out.println(" NEW TIME!");
              times.set(i, ""+newTime);
              fl.saveTextFile("/files/Times.txt", times);
            }
            else if(newTime < Long.parseLong(times.get(i)))
            {
              System.out.println(" NEW BEST :D");
              times.set(i, "" + newTime);
              fl.saveTextFile("/files/Times.txt", times);
            }
            else
              System.out.println(" Best time: " + times.get(i) + "ms");
          }       
        }
      }    
    }
  }
}
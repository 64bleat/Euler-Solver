package main;

import java.util.*;

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

    while(true)
    {
      String input;
      
      System.out.print("Which experiment would you like to do? ");
      input = in.nextLine().toUpperCase();
      
      if(input.contains("?")) //help files
      {
        List<String> file = null;
        
        try{file = fl.loadTextFile("/info/I_" + input.replace("?", "") + ".txt");}
        catch(Exception e){System.out.println("Help file not found.");}
        
        if(file != null)
          for(String l: file)
            System.out.println(l);  
      }
      else if(input.equals("EXIT"))
      {
        System.out.println("Exiting.");
        in.close();
        return;
      }
      else
      {
        P_0 problem = null;
        
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
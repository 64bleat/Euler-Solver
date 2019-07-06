package main;

import java.util.*;
import java.util.function.Function;
import java.awt.Desktop;
import java.net.URI;

import problems.*;
import supplemental.*;

public class Solver
{
  private static Map<String, Function<String[], Boolean>> commands = new HashMap<String, Function<String[], Boolean>>();
  private static Scanner in = new Scanner(System.in);

  private static Map<String, String> newAnswers;
  private static Map<String, String> newTimes;
  
  public static void main(String[] args)
  {
    newAnswers = FileLoader.loadMapFile("/files/Answers.txt");
    newTimes = FileLoader.loadMapFile("/files/Times.txt");
    
    commands.put("exit",  Exit);
    commands.put("solve",  Solve);
    commands.put("link", Link);
    
    System.out.println("===Project Euler Solver===\nInclude \"link\" to load the problem's webpage\nType \"exit\" to... exit.\n==========================");
    
    while(update());  
    
    in.close();
  }
  
  private static boolean update()
  {
    System.out.print("Which problem would you like to solve? "); 
    String[] args = in.nextLine().trim().split(" ");
      
    Function<String[], Boolean> test = commands.get(args[0]);
    
    if(test != null)
      return test.apply(args);
    else
    { 
      String[] newArgs = new String[args.length + 1];
      
      for(int i = args.length - 1; i >= 0; i--)
        newArgs[i+1] = args[i];
      
      commands.get("solve").apply(newArgs);
    }

    return true;
  }
  
  private static Function<String[], Boolean> Exit = (arg) -> 
  {
    System.out.println("Exiting.");    
    return false;
  };
  
  private static Function<String[], Boolean> Solve= (arg) ->
  {
    for(int p = 1; p < arg.length; p++)
    {
      P_0 problem = null;
      
      while(arg[p].length() < 3)
        arg[p] = "0" + arg[p];
      
      try{problem = (P_0)Class.forName("problems.P_" + arg[p]).newInstance();}
      catch(Exception e) {System.out.print("invalid input. ");}
      
      if(problem != null)
      {
        long startTime = System.currentTimeMillis();
        String answer = "" + problem.run();
        String newTime = "" + (System.currentTimeMillis() - startTime);
        
        System.out.println("Output for " + arg[p] + ": " + answer + " (" + newTime + "ms)");
        
        // NEW ANSWER
        if(!newAnswers.containsKey(arg[p]))
        {
          System.out.print("No answer recorded. Is this correct? ");

          if(in.nextLine().toUpperCase().equals("YES"))
            newAnswers.put(arg[p], answer);
          
          FileLoader.saveMapFile("/files/Answers.txt", newAnswers);
        }
        else if(!newAnswers.get(arg[p]).equals(answer))
          System.out.println("WRONG!!! CORRECT ANSWER IS " + newAnswers.get(arg[p]) + " !!!");
        
        // TIME HANDLING
        if(newAnswers.containsKey(arg[p]) && newAnswers.get(arg[p]).equals(answer))
        {
          if(!newTimes.containsKey(arg[p]))
          {
            System.out.println(" NEW TIME!");
            newTimes.put(arg[p], newTime);
            FileLoader.saveMapFile("/files/Times.txt", newTimes);
          }
          else if(Long.parseLong(newTime) < Long.parseLong(newTimes.get(arg[p])))
          {
            System.out.println(" NEW BEST :D");
            newTimes.put(arg[p], newTime);
            FileLoader.saveMapFile("/files/Times.txt", newTimes);
          }
          else
            System.out.println(" Best time: " + newTimes.get(arg[p]) + "ms");
        }       
      }
    }
    
    return true;
  };
  
  private static Function<String[], Boolean> Link = (arg) ->
  {
    for(int i = 1; i < arg.length; i++)
    {      
      while(arg[i].length() < 3)
        arg[i] = "0" + arg[i];
      
      //open links
      if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE))
        try
        {
          Desktop.getDesktop().browse(new URI("https://projecteuler.net/problem=" + Integer.parseInt(arg[i])));
          Desktop.getDesktop().browse(new URI("https://github.com/64bleat/Euler-Solver/blob/master/src/problems/P_" + arg[i] +".java"));
        }
        catch (Exception e){System.out.print("Error loading webpages");}
    }
    
    return true;
  };
}
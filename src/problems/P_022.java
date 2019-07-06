package problems;

import java.util.*;
import supplemental.FileLoader;

public class P_022 extends P_0
{
  public long run()
  {
    List<String> lines = FileLoader.loadTextFile("/files/P_022.txt");
    LinkedList<String> names = new LinkedList<String>();
    LinkedList<String> unsortedNames = new LinkedList<String>();
    long answer = 0;
    
    //Process text file
    for(String l: lines)
      for(String name: l.split(","))
        unsortedNames.add(name.replace("\"", ""));
    
    //Sort names alphabetically
    while(!unsortedNames.isEmpty())
    {
      String name = unsortedNames.removeFirst();
      int i = 0;
      
      while(i < names.size() && names.get(i).compareTo(name) < 0)
       i++;
      
      if(i < names.size())
        names.add(i, name);
      else
        names.add(name);
    }
    
    //System.out.println(names);
    
    //Do the problem
    for(int i = 0; i < names.size(); i ++)
    {
      char[] name = names.get(i).toCharArray();
      long nameValue = 0;
      
      for(int j = 0; j < name.length; j++)
        nameValue += name[j] - 'A' + 1;
      
      answer += nameValue * (i+1);
    }
    
    return answer;
  }
}
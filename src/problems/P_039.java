package problems;

import java.util.*;

public class P_039 extends P_0
{
  public long run()
  {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    Set<Integer> squares = new HashSet<Integer>();
    int max = 0;
    int answer = 0;
    
    for(int i = 1; Math.pow(i, 2) < 1000000; i++)
      squares.add((int)Math.pow(i,2));
    
    for(int a = 1; a <= 1000; a++)
      for(int b = a; a*a + b*b <= 1000000; b++)
      { 
        if(squares.contains(a*a+b*b))
        {
          int per = a + b + (int)Math.sqrt(a*a+b*b);
          
          if(per <= 1000)
          {
            if(map.containsKey(per))
              map.put(per, map.get(per)+1);
            else
              map.put(per, 1);
            
            if(map.get(per) > max)
            {
              max = map.get(per);
              answer = per;
            }
          }
        }   
      }
    return answer;
  }
}

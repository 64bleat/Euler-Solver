package problems;

import java.util.*;

import supplemental.Prime;

public class P_041 extends P_0
{
  public long run()
  {
    long answer = 0;

    Prime.reset();
    
    for(long prime = Prime.next(); prime <= 7654321; prime = Prime.next())
    {
      Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
      boolean pan = true;
      
      for(long temp = prime; pan && temp > 0; temp /= 10)
      {
        int d = (int)temp % 10;
        
        if(d == 0 || map.containsKey(d))
          pan = false;
        else
          map.put(d, true);
      }
          
      for(int x = 1; pan && x <= (int)Math.floor(Math.log10(prime) + 1); x++)
          pan = map.containsKey(x);
      
      if(pan)
        answer = prime;
    }
    
    return answer;
  }
}

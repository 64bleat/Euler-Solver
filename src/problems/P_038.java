package problems;

import java.util.*;

public class P_038 extends P_0
{
  public long run()
  {
    for(int i = 987654321; i >= 123456789; i--)
    {
      if(pan(i))
        return i;
    }
    
      return -1;
  }
  
  private static boolean pan(int n)
  {
    //STEP 1: is n in a valid range?
    //if(n > 987654321 || n < 123456789)
    //  return false; 
    
    //STEP 2: Does n contain 0s or duplicate digits?
    Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    
    for(int t = n; t > 0; t /= 10)
    {
      int d = t % 10;
      
      if(d == 0 || map.containsKey(d))
        return false;
      else
        map.put(d, true);
    }
    
    //STEP 3: Initialize recursion (a starting number larger than 4 digits is impossible)
    for(int d = 1; d <= 4; d++)
      if(panRec((int)(n / Math.pow(10, 9-d)), (int)(n % Math.pow(10, 9-d)), 2))
        return true;
      
    return false;
  }
  
  private static boolean panRec(int a, int r, int m)
  {            
    //Step 5: increment a, using only multiples from the original number.
    a *= (double)m / (m-1);
    
    //Step 7: count digits in a and remainder.
    int rd = (int)Math.floor(Math.log10(r)+1);
    int ad = (int)Math.floor(Math.log10(a)+1);
    int d = (int)Math.pow(10, rd-ad);
    
    if (r == a || (d > 0 && r/d == a))    //Does the remainder contain the next integer?
      if(rd-ad == 0)                      //Does the remainder contain only that integer?
        return true;
      else
        return panRec(a, r % d, ++m);     //recursion, pulling out the next integer from the remainder
    else
      return false;
    
  }
}

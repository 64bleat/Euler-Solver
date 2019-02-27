package problems;

import java.util.*;
import supplemental.Prime;

public class P_023 extends P_0
{
  private static Set<Long> abundantNumbers;
  
  public long run()
  {
    Prime prime = new Prime();
    abundantNumbers = new TreeSet<Long>();
    long answer = 0;
    
    for(long i = 1; i < 28123; i++)
      if(prime.abundanceOf(i) > 0)
        abundantNumbers.add(i);
    
    for(int n = 1; n < 28123; n++)     
      if(sumTest(n))
        answer += n;  
    
    return answer;
  }
  
  private static boolean sumTest(long n)
  {
    for(Long a: abundantNumbers)
      if(a > n)
        break;
      else
        for(Long b: abundantNumbers)
          if(a + b == n)
            return false;
          else if (a + b > n)
            break;
    
    return true; 
  }
}

package problems;
import java.util.List;

import supplemental.Prime;

public class P_047 extends P_0
{
  public long run()
  {
    long i = 644;
    int count = 0;
    
    while(true)
    {
      List<Long> factors = Prime.primeFactorize(i++);
      long lastFactor = -1;
      
      for(int j = 0; j < factors.size(); j++)
        if(factors.get(j) == lastFactor)
          factors.remove(j--);
        else
          lastFactor = factors.get(j);
      
      if(factors.size() == 4)
      {
        if(++count == 4)
          return i - count;
      }
      else
        count = 0;
    }
  }
}

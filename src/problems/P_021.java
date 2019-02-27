package problems;

import supplemental.Prime;

public class P_021 extends P_0
{
  public long run()
  {
    Prime prime = new Prime();
    long answer = 0;
    
    for(int a = 1; a < 10000; a++)
      for(int b = a; b < 10000; b++)
        if(prime.areAmicable(a, b))
          answer += a + b;
    
    return answer;
  }
}

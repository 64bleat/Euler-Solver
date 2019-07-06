package problems;

import supplemental.Prime;

public class P_010 extends P_0
{
  public long run()
  {
    long answer = 0;
    long primeIndex;
    
    Prime.reset();

    while((primeIndex = Prime.next()) < 2000000L)
      answer += primeIndex;
    
    return answer;
  }
}

package problems;

import supplemental.Prime;

public class P_010 extends P_0
{
  public long run()
  {
    Prime prime = new Prime();
    long answer = 0;
    long primeIndex;

    while((primeIndex = prime.next()) < 2000000L)
      answer += primeIndex;
    
    return answer;
  }
}

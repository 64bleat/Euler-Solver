package problems;

import supplemental.Fibonacci;

public class P_002 extends P_0
{
  public long run()
  {
    long n, answer = 0;
    
    Fibonacci.setCursor(0);
    
    while((n = Fibonacci.next()) < 4000000L)
      if(n % 2 == 0)
        answer += n;
    
    return answer;
  }
}

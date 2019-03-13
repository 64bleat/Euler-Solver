package problems;

import supplemental.Fibonacci;

public class P_002 extends P_0
{
  public long run()
  {
    Fibonacci fib = new Fibonacci();
    long n, answer = 0;
    
    while((n = fib.next()) < 4000000L)
      if(n % 2 == 0)
        answer += n;
    
    return answer;
  }
}

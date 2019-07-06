package problems;

import supplemental.Prime;

public class P_027 extends P_0
{
  public long run()
  {
    long answer = 0;
    long maxPrimes = 0;
    
    for(int a = -999; a < 1000; a++)
      for(int b = -1000; b <= 1000; b++)
      {
        int n = 0;
        
        while(Prime.isPrime(n*n + a*n + b))
          n++;
        
        if(n > maxPrimes)
        {
          answer = a * b;
          maxPrimes = n;
        }
      }
    
    return answer;
  }
}

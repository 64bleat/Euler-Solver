package problems;

import supplemental.Prime;

public class P_035 extends P_0
{
  public long run()
  {
    int answer = 0;
    long prime;

    for(int i = 0; (prime = Prime.get(i)) < 1000000; i++)
    {
      int digits = (int)Math.ceil(Math.log10(prime));
      boolean good = true;
      long temp = prime;
      
      for(int perms = digits - 1; good && perms > 0; perms--)
          good = Prime.isPrime(temp = (long)(temp / 10 + (temp % 10) * Math.pow(10, digits - 1)));
   
      if(good)
        answer++;
    }
    
    return answer;
  }
}

package problems;

import supplemental.Prime;

public class P_037 extends P_0
{
  public long run()
  {
    long answer = 0;
    byte count = 0;
    
    for(int i = 4; count < 11; i++) //first ten index at index 4
    {
      long a = Prime.get(i);
      long b = a;
      
      while((a /= 10) > 0 && Prime.isPrime(a));
      
      if(a == 0)
      {
        while(b > 0 && Prime.isPrime(b))
        {
          int digits = (int)Math.pow(10, (int)Math.floor(Math.log10(b)));
          digits *= b / digits;
          b -= digits;
        }
      }
      
      if(b == 0)
      {
        count++;
        System.out.println(Prime.get(i));
        answer += Prime.get(i);
      }
    }
    
    return answer;
  }
}

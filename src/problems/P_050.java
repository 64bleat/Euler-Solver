package problems;

import supplemental.Prime;

public class P_050 extends P_0
{

  public long run()
  {
    long maxPrime = 0;
    int maxCount = 0;
    int testPrime = 0;
    
    for(int startIndex = 0; Prime.get(startIndex) * maxCount < 1000000; startIndex++)
    {
      testPrime = 0;
      
      for(int i = startIndex; testPrime < 1000000; i++)
      {
        testPrime += Prime.get(i);
        
        if(Prime.isPrime(testPrime) && i - startIndex > maxCount)
        {
          maxPrime = testPrime;
          maxCount = i - startIndex;
        }
      }
    }
    
    return maxPrime;
  }
}

package problems;

import supplemental.Prime;

public class P_050 extends P_0
{

  public long run()
  {
    Prime prime = new Prime();
    long maxPrime = 0;
    int maxCount = 0;
    int testPrime = 0;
    
    for(int startIndex = 0; prime.get(startIndex) * maxCount < 1000000; startIndex++)
    {
      testPrime = 0;
      
      for(int i = startIndex; testPrime < 1000000; i++)
      {
        testPrime += prime.get(i);
        
        if(prime.isPrime(testPrime) && i - startIndex > maxCount)
        {
          maxPrime = testPrime;
          maxCount = i - startIndex;
        }
      }
    }
    
    return maxPrime;
  }
}

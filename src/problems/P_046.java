package problems;
import supplemental.Prime;

public class P_046 extends P_0
{
  public long run()
  {
    Prime prime = new Prime();
    long i = 1;
    
    while(true)
      if(!prime.isPrime(i += 2))
      {
        boolean found = false;
        
        for(int n = 1;!found && 2*n*n < i; n++)
          if(prime.isPrime(i-2*n*n))
            found = true;
        
        if(!found)
          return i;
      }
  }
}

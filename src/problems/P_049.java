package problems;

import supplemental.Prime;

public class P_049 extends P_0
{
  public long run()
  {
    int i = 1487;

    while(++i < 10000)
    {
      int offset = 0;
      
      while((i + 2 * ++offset) < 10000)
      {
        boolean isPermutable = true;
        boolean isPrime = true;
        
        for(int k = 0; k < 3 && isPrime && isPermutable; k++)
          if(isPermutable = isPermutation(toChar(i), toChar(i+k*offset)))
            isPrime = Prime.isPrime(i+k*offset);

        if(isPrime && isPermutable)
          return Long.parseLong("" + i + (i+offset) + (i + 2 * offset));
      }
    }
    
    return -1;
  }
  
  public char[] toChar(int n)
  {
    return (""+n).toCharArray();
  }
  
  public boolean isPermutation(char[] a, char[] b)
  {
    if(a.length != b.length)
      return false;
    
    for(char c : a)
      if(count(c, a) != count(c, b))
        return false;
    
    return true;
  }
  
  public int count(char n, char[] chars)
  {
    int i = 0;
   
    for(char c : chars)
      if(c == n)
        i++;
    
    return i;
  }
}

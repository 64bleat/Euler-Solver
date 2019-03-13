package problems;

public class P_045 extends P_0
{
  public long run()
  {
    long nT = 286;
    long nP = 165;
    long nH = 143;
    long vT = -1, vP = -2, vH = -3;
    
    while(vT != vP || vT != vH)
    {      
      long max = Math.max(vT, Math.max(vP, vH));
      
      while(vT < max)
        vT = t(++nT);
      
      while(vP < max)
        vP = p(++nP);
      
      while(vH < max)
        vH = h(++nH);
    }
    
    return t(nT);
  }
  
  private long t(long n)
  {
    return n * (n + 1) / 2;
  }
  
  private long p(long n)
  {
    return n * (3 * n - 1) / 2;
  }
  
  private long h(long n)
  {
    return n * (2 * n - 1);
  }
}

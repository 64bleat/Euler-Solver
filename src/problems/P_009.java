package problems;

public class P_009 extends P_0
{
  public long run()
  {    
    for(long iA = 1; iA < 1000 - 2; iA++)
      for(long iB = 1; iB < 1000 - iA; iB++)
      {
        long iC = 1000 - iA - iB;
        
        if(iA * iA + iB * iB == iC * iC)
          return iA * iB * iC;
      }
    
    return -1;
  }
}

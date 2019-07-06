package problems;

import supplemental.Prime;

public class P_003 extends P_0
{
  public long run()
  {    
    return Prime.primeFactor(600851475143L).getLast();
  }
}

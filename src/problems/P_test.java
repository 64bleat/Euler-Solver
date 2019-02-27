package problems;

import supplemental.SuperNumber;

public class P_test extends P_0
{
  public long run()
  {
    SuperNumber n = new SuperNumber(2);

    for(int i = 0; i < 20; i++)
      System.out.println(n.powerOf(2).toString().length());
    
    return 0;
  }
}

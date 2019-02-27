package problems;

import supplemental.MegaInt;

public class P_025 extends P_0
{
  public long run()
  {
    MegaInt b = new MegaInt("1");
    MegaInt c = new MegaInt("2");
    long i = 3;
    
    while(c.toString().length() < 1000)
    {
      MegaInt newI = new MegaInt(c.toString());
      newI.add(new MegaInt(b.toString()));
      b = c;
      c = newI;
      
      i++;
    }
    
    return i;
  }
}
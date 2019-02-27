package problems;

import supplemental.MegaInt;

public class P_020 extends P_0
{
  public long run()
  {
    MegaInt n = new MegaInt("1");
    char[] digits;
    long answer = 0;
    
    //n = 100!
    for(int i = 1; i <= 100; i++)
      n.multiplyBy(i);
    
    digits = n.toString().toCharArray();
    
    for(int i = 0; i < digits.length; i++)
      answer += Long.parseLong("" + digits[i]);
    
    return answer;
  }
}

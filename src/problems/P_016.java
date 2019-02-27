package problems;

import supplemental.MegaInt;

public class P_016 extends P_0
{
  public long run()
  {
    char[] number = (new MegaInt("2")).powerOf(1000).toString().toCharArray();
    long answer = 0;
    
    for(int i = 0; i < number.length; i++)
      answer += Integer.parseInt("" + number[i]);
    
    return answer; 
  }
}
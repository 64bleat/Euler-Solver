package problems;

public class P_040 extends P_0
{
  public long run()
  {
    long answer = 1;
    String s = "";
    
    for(int i = 0; s.length() <= 1000001; i++)
      s += i;
    
    for(int i = 1; i <= 1000000; i *= 10)
      answer *= Integer.parseInt(""+s.charAt(i));
    
    return answer;
  }
}

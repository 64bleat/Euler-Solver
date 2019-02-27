package problems;

public class P_004 extends P_0
{
  public long run()
  {
    long a, b, answer;
    a = b = answer = 999;
    
    while(b >= 100)
    {
      String s ="" + (a * b);
      
      if(s.length() % 2 == 0)
      {
        String x = s.substring(0, s.length() / 2);
        String y = s.substring(s.length() / 2);
        boolean isPalindrome = true;
       
        for(int i = 0; i < x.length() && isPalindrome; i++)
          if(x.charAt(i) != y.charAt(y.length() - 1 - i))
            isPalindrome = false;
       
        if(isPalindrome && a * b > answer)
          answer = a * b;
      }
      
      if(--a < 100)
        a = --b;
    }
    
    return answer;
  }
}

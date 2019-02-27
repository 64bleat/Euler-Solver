package problems;

public class P_030 extends P_0
{
  public long run()
  {
    long max = 0;
    long answer = 0;
    
    while(true)
    {  
      int oldLength = (""+max).length();
      
      max += Math.pow(9, 5);
      
      int newLength = (""+max).length();
      
      if(newLength == oldLength)
        break;
    }
    
    loop:
    for(int i = 2; i <= 194979 * 2; i++)
    {
      int check = 0;
      
      for(int c = i; c > 0; c /= 10)
        if((check += Math.pow(c % 10, 5)) > i)
          continue loop;
      
      if(check == i)
      {
        answer += check;
        //System.out.println(check);
      }
    }
    
    return answer;
  }
}

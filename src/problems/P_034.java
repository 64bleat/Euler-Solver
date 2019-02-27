package problems;

import java.util.*;

public class P_034 extends P_0
{
  public long run()
  {
    List<Integer> f = new ArrayList<Integer>(10);  
    long answer = 0;
    
    //Quick factorials
    f.add(1);
    for (int i = 1; i <= 9; i++)
      f.add(i * f.get(i-1));
    
    //Finder
    int flag = 0;
    
    for(int i = 3; i <= f.get(9); i++)
    {
      int sum = 0;
      
      for(int rem = i; rem > 0; rem /= 10)
        sum += f.get(rem % 10);

      if (sum == i)
        answer += i;
      
      if(sum >= i)
        flag++;
      else
        flag = 0;
      
      if(flag > 0)
      {
        int pow = (int)Math.pow(10, flag);
        i += pow - i % pow; 
      }
    }
    
    System.out.println(f);
    return answer;
  }
}

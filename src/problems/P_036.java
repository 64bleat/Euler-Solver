package problems;

import java.util.*;

public class P_036 extends P_0
{
  public long run()
  {
    long answer = 0;
    
    for(int i = 1; i < 1000000; i++)
    {
      List<Byte> deDigs = new ArrayList<Byte>((int)Math.floor(Math.log10(i) + 1)); //count digits in base 10
      
      for(int t = i; t > 0; t /= 10)
        deDigs.add((byte)(t % 10));
      
      if(isPalindrome(deDigs))
      {     
        List<Boolean> biDigs = new ArrayList<Boolean>((int)Math.floor(Math.log10(i) / Math.log10(2) + 1)); //count digits in base 2
        
        for(int t = i; t > 0; t /= 2)
          biDigs.add(t % 2 == 1 ? true : false);
        
        if(isPalindrome(biDigs))
          answer += i;
      }
    }
    
    return answer;
  }
  
  private static boolean isPalindrome(List<?> l)
  {
    boolean pal = true;
    
    for(int a = 0; pal && a < l.size()-1-a; a++)
      if(l.get(a) != l.get(l.size()-1-a))
        pal = false;
    
    return pal;
  }
}

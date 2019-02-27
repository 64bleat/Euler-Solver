package problems;

import java.util.*;

public class P_032 extends P_0
{
  public long run()
  {
    LinkedList<Integer> products = new LinkedList<Integer>();
    int answer = 0;
    
    for(int a = 1; a <= 3143; a ++)
      if(pandigital(true, a, null, null))
        for(int b = 1; a * b < 9876543; b++)
          if(pandigital(false, a, b, a * b) && !products.contains(a * b))
            products.add(a * b);
    
    for(int i: products)
      answer += i;
    
    System.out.println("Answer for problem 32 is: " + answer);
    
    return answer;
  }
  
  public static String combine(Integer a, Integer b, Integer c)
  {
    String numbers = new String();
    
    if(a != null && a > 0)
      numbers += a;
    if(b != null && b > 0)
      numbers += b;
    if(c != null && c > 0)
      numbers += c;
    
    return numbers;
  }
  
  public static boolean pandigital(boolean ignoreLength, Integer a, Integer b, Integer c)
  {
    String numbers = combine(a, b, c);
    
    if(numbers == null || numbers.contains("0") || !ignoreLength && numbers.length() != 9)
      return false;

    int[] list = new int[10];
    
    for(int i = 0; i < list.length; i++)
      list[i] = 0;
    
    for(Character x: numbers.toCharArray())
    {
      int y = Integer.parseInt("" + x);
      
      if(++list[y] != 1)
        return false;
    }
    
   
    return true;
  }
}

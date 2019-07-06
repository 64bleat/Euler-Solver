package problems;

import supplemental.Prime;

public class P_043 extends P_0
{  
  final static  int NUM_DIGITS = 10;
  private static long answer;
  
  public long run()
  {
    int[] dig = new int[NUM_DIGITS];
    
    answer = 0;
    
    for(int i = 0; i < NUM_DIGITS; i++)
      dig[i] = i;
    
    permute(dig, NUM_DIGITS); 
    
    return answer;
  }
  
  static void permute(int a[], int size)
  {
    // Problem specific test
    if(size == 1)
    {       
      boolean match = true;
      
      for(int i = 1; match && i <= NUM_DIGITS - 3; i++)
      {
        int temp = a[i] * 100 + a[i+1] * 10 + a[i+2];
        
        if(temp % Prime.get(i-1) != 0)
          match = false;
      }
     
      if(match)
        answer += Long.parseLong(concat(a));
    }
    
    //Heap's Algorithm
    for(int i = 0; i < size; i++)
    {
      permute(a, size-1);
      
      if(size % 2 == 1)
      {
        int temp = a[0];
        a[0] = a[size-1];
        a[size-1] = temp;
      }
      else
      {
        int temp = a[i];
        a[i] = a[size-1];
        a[size-1] = temp;
      }
    }
  }
  
  
  private static String concat(int[] dig)
  {
    String s = "";
    
    for(int i : dig)
      s += i;
    
    return s;
  }
}

package problems;

import supplemental.Prime;

public class P_026 extends P_0
{
  public long run()
  {   
    long answer = 0; 
    long maxLength = 0;
    
    Prime.reset();
    
    for(long n = Prime.next(); n < 1000; n = Prime.next())
    {
      if(n == 2 || n == 5)
        continue;

      long length = 0;
      long remainder = 1;

      for(length = 0; length == 0 || remainder != 1; length++)
        remainder = (remainder * 10) % n;

      if(length > maxLength)
      {
        answer = n;
        maxLength = length;
      }
    }
    
    return answer;
  }
}
  
  //private static int MAX = 3;
    /*for(long denom = 900; denom < 984; denom++)
    {
      LinkedList<Long> decimal = new LinkedList<Long>();
      long patternLength = 0;
      long patternStart = 0;
      long remainder = 1;
      long digitLength = 0;
      
      while(Math.pow(10, digitLength) <= denom)
        digitLength++;
      
      creationloop:
      while(true)
      {

        long digit = remainder * 10 / denom;
        remainder = (remainder * 10) % denom;
        decimal.add(digit % 10);
        
        for(patternLength = 1; patternLength <= decimal.size() / 2; patternLength++)
        {
          if(patternLength == 1)
            MAX = 5;
          else
            MAX = 2;
          
          LinkedList<Long> duplicate = new LinkedList<Long>();
          LinkedList<LinkedList<Long>> patternCheck = new LinkedList<LinkedList<Long>>();
          int lastPattern = 0;
          
          //create duplicate 
          for(Long l: decimal)
            duplicate.add(l);
          
          //create patterns in reverse
          while(!duplicate.isEmpty())
          {
            LinkedList<Long> pattern = new LinkedList<Long>();
            patternCheck.add(pattern);
            
            for(int i = 0; i < patternLength && !duplicate.isEmpty(); i++)
              pattern.add(duplicate.removeLast());
          } 
          
          //find repeated parts
          while(lastPattern < patternCheck.size() - 1)
            if(areEqual(patternCheck.get(0), patternCheck.get(lastPattern + 1)))
              lastPattern++;
            else
              break;
          
          //Congrats! pattern found!
          if(lastPattern >= MAX)
          {
            patternStart = 1;

            for(int i = lastPattern + 1; i < patternCheck.size(); i++)
              patternStart += patternCheck.get(i).size();
              
            break creationloop;
          }
        }//end pattern
      }//end creation
      
      if(patternLength > maxLength)
      {
        maxLength = patternLength;
        answer = denom;
        
        System.out.print("0.");
        for(long l: decimal)
          System.out.print(l);
        System.out.println("...");
        System.out.print("  ");
        for(int i = 1; i < patternStart; i++)
          System.out.print(" ");
        System.out.print("S");
        for(int i = 0; i < MAX; i++)
        {
          for(int j = 1; j < patternLength; j++)
            System.out.print(" ");
          System.out.print("^");
        }
        System.out.println();
        System.out.println("anwswer is now " + answer + " with a pattern length of " + maxLength);
      }
    }
  }

  
  private static boolean areEqual(List<Long> a, List<Long> b)
  {
    if(a == null || b == null || a.isEmpty() || a.size() != b.size())
      return false;
    else
      for(int i = 0; i < a.size(); i++)
        if(a.get(i) != b.get(i))
          return false;
    
    return true;
  }
}*/

package problems;

public class P_017 extends P_0
{
  public long run()
  {
    long answer = 0;
    
    for(int i = 1; i <= 1000; i++)
      answer += spell(i).length();
    
    return answer;
  }
  
  private static String spell(int i)
  {
    String word = "";
    
    if(i >= 1000)
      word += spell(i / 1000) + "thousand";
    
    if(i % 1000 / 100 != 0)
      word += spell(i % 1000 / 100) + "hundred";
    
    if((i / 1000 >= 1 && i % 1000 != 0) || (i / 100 >= 1 && i % 100 != 0))
        word += "and";
    
    if(i % 100 >= 20)
    {
      switch(i % 100 / 10)
      {
      case 2: word += "twenty"; break;
      case 3: word += "thirty"; break;
      case 4: word += "forty"; break;
      case 5: word += "fifty"; break;
      case 6: word += "sixty"; break;
      case 7: word += "seventy"; break;
      case 8: word += "eighty"; break;
      case 9: word += "ninety"; break;
      }
    }
    else if(i % 100 >= 10)
    {
      switch(i % 100)
      {
      case 10: word += "ten"; break;
      case 11: word += "eleven"; break;
      case 12: word += "twelve"; break;
      case 13: word += "thirteen"; break;
      case 14: word += "fourteen"; break;
      case 15: word += "fifteen"; break;
      case 16: word += "sixteen"; break;
      case 17: word += "seventeen"; break;
      case 18: word += "eighteen"; break;
      case 19: word += "nineteen"; break;
      }
      
      return word;
    }
    
    switch(i % 10)
    {
    case 1: word += "one"; break;
    case 2: word += "two"; break;
    case 3: word += "three"; break;
    case 4: word += "four"; break;
    case 5: word += "five"; break;
    case 6: word += "six"; break;
    case 7: word += "seven"; break;
    case 8: word += "eight"; break;
    case 9: word += "nine"; break;
    case 0:
      if(i == 0)
        word += "zero";
    }
    
    return word;
  }
}
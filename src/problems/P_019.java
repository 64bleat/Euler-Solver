package problems;

public class P_019 extends P_0
{
  public long run()
  {
    long answer = 0;
    long offset = 1; //First of 1900 was a Monday.
    
    for(int year = 1900; year <= 2000; year++)
    {
      answer += mondaySundays(offset, year);
      
      if(isLeapYear(year))
        offset = (offset + 366) % 7;
      else
        offset = (offset + 365) % 7;
    }
    
    return answer;
  }
  
  private static long mondaySundays(long offsetDays, long year)
  {
    long ms = 0;
    
    if(year < 1901 || year > 2000)
      return ms;

    if((offsetDays += 0 ) % 7 == 0) ms++; //January
    if((offsetDays += 31) % 7 == 0) ms++; //February
    if(isLeapYear(year)) offsetDays += 29;
    else                 offsetDays += 28;
    if((offsetDays += 0 ) % 7 == 0) ms++; //March
    if((offsetDays += 31) % 7 == 0) ms++; //April
    if((offsetDays += 30) % 7 == 0) ms++; //May
    if((offsetDays += 31) % 7 == 0) ms++; //June
    if((offsetDays += 30) % 7 == 0) ms++; //July
    if((offsetDays += 31) % 7 == 0) ms++; //August
    if((offsetDays += 31) % 7 == 0) ms++; //September
    if((offsetDays += 30) % 7 == 0) ms++; //October
    if((offsetDays += 31) % 7 == 0) ms++; //November
    if((offsetDays += 30) % 7 == 0) ms++; //December
      
    return ms;      
  }
  
  private static boolean isLeapYear(long year)
  {
    return year % 4 == 0 || (year % 100 == 0 && year % 400 == 0);
  }
}

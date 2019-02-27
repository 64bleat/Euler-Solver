package problems;

public class P_033 extends P_0
{
  public long run()
  {
    double answer = 1;
    
    for(int nom = 12; nom < 99; nom += ((nom+1) % 10 == 0 || (nom+1) % 10 == (nom+1) / 10) ? 2 : 1)
    { 
       for(int den = nom; den < 100; den += ((den+1) % 10 == 0 || (den+1) % 10 == (den+1) / 10) ? 2 : 1)
       {
         int a, b;
         
         if(den == nom)
           continue;         
         else if(nom / 10 == den / 10)
         {
           a = nom % 10;
           b = den % 10;
         }
         else if(nom / 10 == den % 10)
         {
           a = nom % 10;
           b = den / 10;
         }
         else if(nom % 10 == den / 10)
         {
           a = nom / 10;
           b = den % 10;
         }
         else if(nom % 10 == den % 10)
         {
           a = nom / 10;
           b = den / 10;
         }
         else
           continue;
         
         //nasty sig fig collection.
         int first = (int)((double)nom/den * 10000000);
         int second = (int)((double)a/b * 10000000);
         
         if(first == second)
           answer *= (double)a / b;   
       }
    }
    
    //nasty rounding
    answer = 1.0 / answer;
    if(answer - (long)answer >= 0.5)
    answer++;
    
    return (long)answer;
  }
}

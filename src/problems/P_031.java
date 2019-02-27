package problems;

public class P_031 extends P_0
{
  public long run()
  {
    long answer = 0;
    long max = 200;
    
    for(int a = 0; a <= max; a += 200)
    for(int b = 0; a+b <= max; b += 100)
    for(int c = 0; a+b+c <= max; c += 50)
    for(int d = 0; a+b+c+d <= max; d += 20)
    for(int e = 0; a+b+c+d+e <= max; e += 10)
    for(int f = 0; a+b+c+d+e+f <= max; f += 5)
    for(int g = 0; a+b+c+d+e+f+g <= max; g += 2)
    for(int h = 0; a+b+c+d+e+f+g+h <= max; h += 1)
      if(a+b+c+d+e+f+g+h == max)
        answer++;
      
    return answer;
  }
}
package problems;

public class P_006 extends P_0
{
  public long run()
  {
    long answer, sumOfSquares, squareOfSum;
    
    squareOfSum = 100 * 100 / 2 + 100 / 2;
    squareOfSum *= squareOfSum;
    sumOfSquares = 0;
    
    for(long i = 1; i <= 100; i++)
      sumOfSquares += i * i;
    
    answer = squareOfSum - sumOfSquares;
    
    return answer;
  }
}

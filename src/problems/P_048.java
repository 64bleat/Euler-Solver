package problems;
import java.math.BigInteger;

public class P_048 extends P_0
{
  public long run()
  {
    BigInteger answer = new BigInteger("0");
    
    for(Integer i = 1; i <= 1000; i++)
      answer= answer.add(new BigInteger(i.toString()).pow(i));
    
    return Long.parseLong((answer.toString().substring(answer.toString().length()-10)));
  }
}

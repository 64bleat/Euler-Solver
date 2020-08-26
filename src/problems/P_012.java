package problems;

import java.util.*;
import supplemental.Prime;

public class P_012 extends P_0
{
  public long run()
  {
    long triangle = 0;
    List<Long> divisors = new LinkedList<Long>();
    
    for(int i = 0; divisors.size() < 500;)
      divisors = Prime.factorize(triangle += i++);

    return triangle;
  }
}

package problems;

import java.util.HashMap;
import java.util.Map;

public class P_014 extends P_0
{
  private static Map<Long, Long> map;
  
  public long run()
  {
    map = new HashMap<Long, Long>();
    long answer, chainLength;
    answer = chainLength = 0;
    
    for(long i = 1; i <= 1000000; i++)
      if(makeChainFor(i) > chainLength)
        chainLength = makeChainFor(answer = i);
    
    return answer;
  }
  
  private static Long makeChainFor(Long i)
  {
    Long chainLength;
    
    if((chainLength = map.get(i)) != null)
      return chainLength;
    else if(i == 1L)
      chainLength = 1L;
    else if(i % 2 == 0)
      chainLength =  1L + makeChainFor(i / 2);
    else
      chainLength = 1L + makeChainFor(3 * i + 1);
    
    map.put(i, chainLength);
      
    return chainLength;
  }
}
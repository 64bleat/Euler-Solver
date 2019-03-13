package problems;

import java.util.HashMap;

public class P_044 extends P_0
{
  private HashMap<Integer, Integer> forward = new HashMap<Integer, Integer>();
  private HashMap<Integer, Integer> reverse = new HashMap<Integer, Integer>();
  private int maxIndex = 0;
  private int maxValue = 0;

  public long run()
  {
    for(int k = 1; k < Integer.MAX_VALUE; k++)
      for(int j = k - 1; j > 0; j--)
        if(d(p(k) + p(j)) && d(p(k) - p(j)))
          return(p(k)-p(j));
    
    return 0;
  }
  
  private int p(int n)
  {
    while(maxIndex <= n)
      increment();
    
    return forward.get(n);
  }

  private boolean d(int n)
  {
    while(maxValue <= n)
      increment();
    
    return reverse.containsKey(n);
  }
  
  private void increment()
  {
    int p = maxIndex * (3 * maxIndex - 1) / 2;
    forward.put(maxIndex, p);
    reverse.put(p, maxIndex);
    maxIndex++;
    maxValue = p;
  }
}

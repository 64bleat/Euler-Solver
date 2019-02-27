package supplemental;

import java.util.*;

/**
 *  An object designed to make finding fibonacci numbers faster.
 */
public class Fibonacci
{
  private Map<Integer, Long> values;
  private int cursor;
  
  /**
   *  Returns the Fibonacci number at the given index. When the object is created,
   *  it maps all found numbers to an index for faster returns. <p>
   *  
   *  The object's cursor is set to i + 1.
   *  
   *  @param i  The index of the requested nubmer.
   *  @return   The Fibonacci number at the given index.
   */
  public long valueAt(int i)
  {    
    while(values.size() <= i)
      values.put(values.size(), values.get(values.size() - 1) + values.get(values.size() - 2));
    
    return values.get(i);
  }
  
  /**
   * Returns the next fibonacci number and increments the cursor.
   * 
   * @return    The next fibonacci number after cursor.
   */
  public long next()
  {
    return valueAt(cursor++); 
  }
  
  public Fibonacci()
  {
    values = new HashMap<Integer, Long>();
    values.put(0, 1L);
    values.put(1, 2L);
    
    cursor = 0;
  }
}

package supplemental;

import java.util.*;

/** An object designed to make finding fibonacci numbers faster. */
public class Fibonacci
{
  private static int cursor = 0;
  private static Map<Integer, Long> values = new HashMap<Integer, Long>()
  {
    {
      put(0, 1L);
      put(1, 2L);
    }
  };
  
  /** Returns the Fibonacci number at the given index. When the object is created,
   *  it maps all found numbers to an index for faster returns. <p>
   *  
   *  The cursor is set to i + 1.*/
  public static long valueAt(int i)
  {    
    while(values.size() <= i)
      values.put(values.size(), values.get(values.size() - 1) + values.get(values.size() - 2));
    
    return values.get(i);
  }
  
  /** Returns the fibonacci number and increments the cursor.
   * @return    The fibonacci number at cursor.. */
  public static long next()
  {
    return valueAt(cursor++); 
  }
  
  /** sets the cursor to a specific index. */
  public static void setCursor(int c)
  {
    cursor = c;
  }
}

package supplemental;

import java.util.*;

/**
 * Fibonacci Numbers. Calculating fibonacci numbers takes time, so it is
 * worthwhile to store the values.
 * @see <a href = "https://en.wikipedia.org/wiki/Fibonacci_number"> Wikipedia:
 *      Fibonacci Number </a>
 */
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

	/**
	 * Get the number at index i in the fibonacci sequence. index 0 = 1.
	 * @param i Fibonacci index
	 * @return the fibonacci number at index i.
	 */
	public static long valueAt(int i)
	{
		while (values.size() <= i)
			values.put(values.size(), values.get(values.size() - 1) + values.get(values.size() - 2));

		return values.get(i);
	}

	/**
	 * Get the fibonacci number at the cursor, then increment the cursor.
	 * @return The fibonacci number at cursor.
	 */
	public static long next()
	{
		return valueAt(cursor++);
	}

	/**
	 * sets the cursor to the specified index
	 * @param i index
	 */
	public static void setCursor(int i)
	{
		cursor = i;
	}
}

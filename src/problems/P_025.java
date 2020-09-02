package problems;

import supplemental.LargeInt;

/**
 * <b>1000-digit Fibonacci number</b><br>
 * find the index of the first Fibonacci number with 1000 digits.
 */
public class P_025 extends P_0
{
	public long run()
	{
		LargeInt b = new LargeInt("1");
		LargeInt c = new LargeInt("2");
		long i = 3;

		while (c.toString().length() < 1000)
		{
			LargeInt newI = new LargeInt(c.toString());
			newI.add(new LargeInt(b.toString()));
			b = c;
			c = newI;

			i++;
		}

		return i;
	}
}
package problems;

import supplemental.Prime;

/**
 * <b>Smallest Multiple</b><br>
 * Find the smallest positive number that is evenly divisible by all numbers
 * from 1 to 20.
 * @see supplemental.Prime#perfectTo(int)
 */
public class P_005 extends P_0
{
	public long run()
	{
		return Prime.perfectTo(20);
	}
}

package problems;

import supplemental.Prime;

/**
 * Smallest Multiple
 * 
 * Find the smallest positive number that is evenly divisible by all numbers from 1 to 20. 
 *
 */
public class P_005 extends P_0
{
	public long run()
	{
		return Prime.perfectTo(20);
	}
}

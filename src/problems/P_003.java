package problems;

import supplemental.Prime;

/**
 * Largest Prime Factor
 * 
 * Find the largest prime factor of 600851475143.
 */
public class P_003 extends P_0
{
	public long run()
	{
		return Prime.primeFactorize(600851475143L).getLast();
	}
}

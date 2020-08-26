package problems;

import supplemental.Prime;

/**
 * <b>Largest Prime Factor</b><br>
 * Find the largest prime factor of 600851475143.
 * @see supplemental.Prime#primeFactorize(long)
 */
public class P_003 extends P_0
{
	public long run()
	{
		return Prime.primeFactorize(600851475143L).getLast();
	}
}

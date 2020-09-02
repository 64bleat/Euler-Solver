package problems;

import supplemental.Prime;

/**
 * <b>Highly divisible triangular number</b><br>
 * Find the value of the first triangular number to have over 500 divisors
 * @see supplemental.Prime#factorize(long)
 * @see <a href = "https://en.wikipedia.org/wiki/Triangular_number">
 * 		Wikipedia: Triangular number </a>
 */
public class P_012 extends P_0
{
	public long run()
	{
		long triangle = 0;
		int i = 0;
		
		while(Prime.factorize(triangle += i++).length < 500);

		return triangle;
	}
}

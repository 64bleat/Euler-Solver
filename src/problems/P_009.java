package problems;

/**
 * <b>Special Pythagorean Triplet</b><br>
 * Pythagorean triplets are sets of natural numbers where <br>
 * <code>a*a + b*b = c*c</code><br>
 * Find the only Pythagorean triplet where<br>
 * <code>a + b + c = 1000</code><br>
 * and return<br>
 * <code>a * b * c</code>
 * @see <a href = https://en.wikipedia.org/wiki/Pythagorean_triple"> Wikipedia:
 *      Pythagorean triple </a>
 */
public class P_009 extends P_0
{
	public long run()
	{
		for (long a = 1; a < 1000 - 2; a++)
			for (long b = 1; b < 1000 - a; b++)
			{
				long c = 1000 - a - b;

				if (a * a + b * b == c * c)
					return a * b * c;
			}

		return -1;
	}
}

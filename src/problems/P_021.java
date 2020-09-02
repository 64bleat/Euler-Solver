package problems;

import supplemental.Prime;

/**
 * <b>Amicable numbers</b><br>
 * Summate all amicable numbers under 10000.
 * @see <a href = "https://en.wikipedia.org/wiki/Amicable_numbers">
 * 		Wikipedia: Amicable nubmers </a>
 */
public class P_021 extends P_0
{
	public long run()
	{
		long answer = 0;

		for (int a = 1; a < 10000; a++)
			for (int b = a; b < 10000; b++)
				if (Prime.areAmicable(a, b))
					answer += a + b;

		return answer;
	}
}

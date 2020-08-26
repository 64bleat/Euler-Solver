package problems;

import supplemental.MegaInt;

/**
 * <b>Factorial digit sum</b><br>
 * Find the sum of the digits in the number <code>100!</code>
 * @see <a href = "https://en.wikipedia.org/wiki/Factorial"> Wikipedia:
 *      Factorial </a>
 */
public class P_020 extends P_0
{
	public long run()
	{
		MegaInt factorial = new MegaInt("1");
		long answer = 0;

		// Factorial
		for (int i = 1; i <= 100; i++)
			factorial.multiplyBy(i);

		// Digit Sum
		for (char c : factorial.toString().toCharArray())
			answer += c - '0';

		return answer;
	}
}

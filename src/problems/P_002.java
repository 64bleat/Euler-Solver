package problems;

import supplemental.Fibonacci;

/**
 * Even Fibonacci Numbers
 * 
 * Summate all even-valued Fibonacci numbers below 4 000 000.
 */
public class P_002 extends P_0
{
	public long run()
	{
		long n, answer = 0;

		Fibonacci.setCursor(0);

		while ((n = Fibonacci.next()) < 4000000L)
			if (n % 2 == 0)
				answer += n;

		return answer;
	}
}

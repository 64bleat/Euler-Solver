package problems;

import supplemental.Prime;

/**
 * <b>Summation of Primes</b><br>
 * Summate all primes below 2 000 000
 * @see supplemental.Prime#next()
 */
public class P_010 extends P_0
{
	public long run()
	{
		long answer = 0;
		long prime;

		Prime.reset();

		while ((prime = Prime.next()) < 2000000L)
			answer += prime;

		return answer;
	}
}

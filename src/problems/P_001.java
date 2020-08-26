package problems;

/**
 * Multiples of 3 and 5
 * 
 * Summate all multiples of 3 or 5 below 1000.
 *
 */
public class P_001 extends P_0
{
	// This is the offset pattern for integers divisible by 3 and 5.
	private static final int[] next = { 3, 2, 1, 3, 1, 2, 3 };
	
	public long run()
	{
		int answer = 0, n = 0, i = 0;

		while ((n += next[i++ % next.length]) < 1000)
			answer += n;

		return answer;
	}
}

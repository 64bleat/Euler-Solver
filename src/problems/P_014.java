package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Longest Collatz sequence</b><br>
 * Find the number under 1 000 000 that generates the longest Collatz sequence.
 * @see <a href = "https://en.wikipedia.org/wiki/Collatz_conjecture"> 
 * 		Wikipedia: Collatz Conjecture </a>
 */
public class P_014 extends P_0
{
	private static Map<Long, Long> map = new HashMap<Long, Long>();;

	public long run()
	{
		long answer = 0;
		long maxLength = 0;

		for (long i = 1; i <= 1000000; i++)
			if (getCollatzSequence(i) > maxLength)
				maxLength = getCollatzSequence(answer = i);

		return answer;
	}

	private static long getCollatzSequence(Long i)
	{
		Long chainLength;

		if ((chainLength = map.get(i)) != null)
			return chainLength;
		else if (i == 1L)
			chainLength = 1L;
		else if (i % 2 == 0)
			chainLength = 1L + getCollatzSequence(i / 2);
		else
			chainLength = 1L + getCollatzSequence(3 * i + 1);

		map.put(i, chainLength);

		return chainLength;
	}
}
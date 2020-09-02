package problems;

import java.util.*;
import supplemental.Prime;

/**
 * <b>Non-abundant sums</b><br>
 * Summate all positive integers which cannot be written as the sum of two
 * abundant numbers. 28123 is the maximum.
 */
public class P_023 extends P_0
{
	private static final LinkedList<Long> abundantNumbers = new LinkedList<Long>();

	public long run()
	{
		long answer = 0;

		for (long i = 1; i < 28123; i++)
			if (Prime.abundanceOf(i) > i)
				abundantNumbers.add(i);

		for (int n = 1; n < 28123; n++)
			if (sumTest(n))
				answer += n;

		return answer;
	}

	private static boolean sumTest(long n)
	{
		for (Long a : abundantNumbers)
			if (a > n)
				break;
			else
				for (Long b : abundantNumbers)
					if (a + b == n)
						return false;
					else if (a + b > n)
						break;

		return true;
	}
}
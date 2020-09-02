package problems;

import supplemental.Prime;

/**
 * <b>Reciprocal cycles</b><br>
 * What number under 1000 who's reciprocal contains the longest recurring
 * pattern in its decimal fraction.
 */
public class P_026 extends P_0
{
	public long run()
	{
		long answer = 0;
		long maxLength = 0;

		Prime.reset();

		for (long n = Prime.next(); n < 1000; n = Prime.next())
			if (n != 2 && n != 5)
			{
				long length = 0;
				long remainder = 1;

				for (length = 0; length == 0 || remainder != 1; length++)
					remainder = (remainder * 10) % n;

				if (length > maxLength)
				{
					answer = n;
					maxLength = length;
				}
			}

		return answer;
	}
}

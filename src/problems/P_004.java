package problems;

/**
 * <b>Largest Palindrome Product</b><br>
 * Find the largest palindromic base-10 integer made from the product of two
 * 3-digit numbers.
 */
public class P_004 extends P_0
{
	public long run()
	{
		long a, b, answer;

		a = b = answer = 999;

		while (b >= 100)
		{
			if (a * b > answer)
			{
				String s = "" + (a * b);
				int l = 0;
				int h = s.length() - 1;
				boolean isPalindrome;

				do
					isPalindrome = s.charAt(l) == s.charAt(h);
				while (isPalindrome && ++l < --h);

				if (isPalindrome)
					answer = a * b;

			}

			if (--a < 100)
				a = --b;
		}

		return answer;
	}
}

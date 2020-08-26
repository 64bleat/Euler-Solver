package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Number letter counts</b><br>
 * If all numbers from 1 through 1000 were written out as full words, count the
 * number of characters used.
 */
public class P_017 extends P_0
{
	private static final Map<Integer, String> ones = new HashMap<Integer, String>()
	{
		{
			put(0, "zero");
			put(1, "one");
			put(2, "two");
			put(3, "three");
			put(4, "four");
			put(5, "five");
			put(6, "six");
			put(7, "seven");
			put(8, "eight");
			put(9, "nine");
		}
	};
	private static final Map<Integer, String> tens = new HashMap<Integer, String>()
	{
		{
			put(2, "twenty");
			put(3, "thirty");
			put(4, "forty");
			put(5, "fifty");
			put(6, "sixty");
			put(7, "seventy");
			put(8, "eighty");
			put(9, "ninety");
		}
	};
	private static final Map<Integer, String> teens = new HashMap<Integer, String>()
	{
		{
			put(10, "ten");
			put(11, "eleven");
			put(12, "twelve");
			put(13, "thirteen");
			put(14, "fourteen");
			put(15, "fifteen");
			put(16, "sixteen");
			put(17, "seventeen");
			put(18, "eighteen");
			put(19, "nineteen");
		}
	};

	public long run()
	{
		long answer = 0;

		for (int i = 1; i <= 1000; i++)
			answer += spell(i).length();

		return answer;
	}

	private static String spell(int n)
	{
		String word = "";

		// Thousands
		if (n >= 1000)
			word += spell(n / 1000) + "thousand";

		// Hundreds
		if (n % 1000 / 100 != 0)
			word += spell(n % 1000 / 100) + "hundred";

		// Conjunction
		if ((n / 1000 >= 1 && n % 1000 != 0) || (n / 100 >= 1 && n % 100 != 0))
			word += "and";

		// Tens
		if (n % 100 >= 20)
			word += tens.get(n % 100 / 10);
		else if (n % 100 >= 10)
			return word + teens.get(n % 100);

		// Ones
		if (n == 0)
			word += ones.get(0);
		else if (n % 10 != 0)
			word += ones.get(n % 10);

		return word;
	}
}
package problems;

import supplemental.FileLoader;

/**
 * <b>Large sum</b><br>
 * Given 100 50-diget integers, find the first 10 digits of the sum of all
 * integers.
 */
public class P_013 extends P_0
{
	public long run()
	{
		double answer = 0;

		for (String i : FileLoader.loadLines("/files/P_013.txt"))
			answer += Double.parseDouble(i);

		return Long.parseLong(String.format("%10.0f", answer).substring(0, 10));
	}
}

package problems;

import java.util.*;
import supplemental.FileLoader;

/**
 * <b>Largest product in a series</b><br>
 * Given a 1000-digit integer, find the highest possible product of 13 adjacent
 * digits.
 * @see supplemental.FileLoader#loadIntArray(String)
 */
public class P_008 extends P_0
{
	public long run()
	{
		List<LinkedList<Integer>> n = FileLoader.loadIntArray("/files/P_008.txt");
		List<Integer> nList = new LinkedList<Integer>();
		long answer = 0;

		for (LinkedList<Integer> y : n)
			for (Integer x : y)
				nList.add(x);

		for (int i = 0; i < nList.size() - 13; i++)
		{
			long candidate = 1;

			for (int x = i; x - i < 13; x++)
				candidate *= nList.get(x);

			if (candidate > answer)
				answer = candidate;
		}

		return answer;
	}
}

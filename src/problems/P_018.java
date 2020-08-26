package problems;

import java.util.*;
import supplemental.FileLoader;

/**
 * <b>Maximum path sum I</b><br>
 * Starting from the top of a number triangle and progressing through lower
 * adjacent numbers to the bottom, find the maximum sum path.
 */
public class P_018 extends P_0
{
	static LinkedList<LinkedList<Long>> lines;

	public long run()
	{
		lines = new LinkedList<LinkedList<Long>>();
		long answer = 0;

		// LOAD
		for (String s : FileLoader.loadLines("/files/P_018.txt"))
		{
			LinkedList<Long> newLine = new LinkedList<Long>();

			for (String n : s.split(" "))
				newLine.add(Long.parseLong(n));

			lines.add(newLine);
		}

		// PATHFINDER
		for (int y = 1; y < lines.size(); y++)
			for (int x = 0; x < lines.get(y).size(); x++)
			{
				long left, right;
				left = right = -1;

				if (x < lines.get(y).size() - 1)
					right = get(x, y - 1);
				if (x > 0)
					left = get(x - 1, y - 1);

				if (left > right)
					lines.get(y).set(x, get(x, y) + left);
				else
					lines.get(y).set(x, get(x, y) + right);
			}

		// FINISH
		for (Long l : lines.getLast())
			if (l > answer)
				answer = l;

		return answer;
	}

	private static Long get(int x, int y)
	{
		return lines.get(y).get(x);
	}
}

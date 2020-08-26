package problems;

import java.util.*;
import supplemental.FileLoader;

/**
 * <b>Largets product in a grid</b><br>
 * Given a 2d array of integers, find the greatest product of 4 adjacent numbers
 * in the same direction. Can be up, down, or diagonal.
 */
public class P_011 extends P_0
{
	private static LinkedList<LinkedList<Long>> grid;

	public long run()
	{
		long answer = 0;
		List<String> lines = FileLoader.loadLines("/files/P_011.txt");

		grid = new LinkedList<LinkedList<Long>>();

		for (String l : lines)
		{
			grid.add(new LinkedList<Long>());
			String[] ls = l.split(" ");

			for (int i = 0; i < ls.length; i++)
				grid.getLast().add(Long.parseLong(ls[i]));
		}

		// Horizontal
		for (int y = 0; y < 20; y++)
			for (int x = 0; x < 20 - 4; x++)
			{
				long test = 1;
				for (int n = 0; n < 4; n++)
					test *= get(x + n, y);
				if (test > answer)
					answer = test;
			}

		// vertical
		for (int x = 0; x < 20; x++)
			for (int y = 0; y < 20 - 4; y++)
			{
				long test = 1;
				for (int n = 0; n < 4; n++)
					test *= get(x, y + n);
				if (test > answer)
					answer = test;
			}

		// diagonal down
		for (int x = 0; x < 20 - 4; x++)
			for (int y = 0; y < 20 - 4; y++)
			{
				long test = 1;
				for (int n = 0; n < 4; n++)
					test *= get(x + n, y + n);
				if (test > answer)
					answer = test;
			}

		// diagonal up
		for (int x = 0; x < 20 - 4; x++)
			for (int y = 4; y < 20; y++)
			{
				long test = 1;
				for (int n = 0; n < 4; n++)
					test *= get(x + n, y - n);
				if (test > answer)
					answer = test;
			}

		return answer;
	}

	private static long get(int x, int y)
	{
		if (x > 0 && y > 0 && y < grid.size() && x < grid.get(y).size())
			return grid.get(y).get(x);
		else
			return 0L;
	}
}

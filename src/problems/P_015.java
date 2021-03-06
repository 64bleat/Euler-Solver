package problems;

import java.util.LinkedList;

/**
 * <b>Lattice paths</b><br>
 * How many possible routes are there through a 20x20 grid between opposite corners?
 */
public class P_015 extends P_0
{
	private static LinkedList<LinkedList<Long>> array;

	public long run()
	{
		// first row
		array = new LinkedList<LinkedList<Long>>();
		array.add(new LinkedList<Long>());
		array.getLast().add(1L);

		// consecutive rows
		for (int y = 1; y <= 20; y++)
		{
			array.add(new LinkedList<Long>());

			for (int x = 0; x <= y; x++)
				if (x != y)
					array.getLast().add(get(x, y - 1) + get(x - 1, y));
				else
					array.getLast().add(get(x - 1, y - 1) + get(x - 1, y) + get(x - 2, y));
		}

		return array.getLast().getLast();
	}

	private static long get(int x, int y)
	{
		try
		{
			return array.get(y).get(x);
		}
		catch (Exception e)
		{
			return 0L;
		}
	}
}
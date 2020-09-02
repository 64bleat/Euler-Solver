package problems;

import java.util.*;

import supplemental.SuperNumber;

/**
 * <b>Distinct powers</b><br>
 * How many distinct terms are there for pow(a, b) when 2 <= a <= 100 and 2 <= b
 * <= 100?
 */
public class P_029 extends P_0
{
	public long run()
	{
		Set<String> terms = new TreeSet<String>();

		for (int a = 2; a <= 100; a++)
			for (int b = 2; b <= 100; b++)
				terms.add((new SuperNumber(a)).powerOf(b).toString());

		return terms.size();
	}
}

package problems;

import java.util.*;
import supplemental.FileLoader;

/**
 * <b>Names scores</b><br>
 * Alphabetize a list of names. Summate the character values of each name,
 * multiply the sum by the name's index number, summate this value for every
 * name. Confusing enough?
 */
public class P_022 extends P_0
{
	public long run()
	{
		List<String> lines = FileLoader.loadLines("/files/P_022.txt");
		LinkedList<String> names = new LinkedList<String>();
		LinkedList<String> unsortedNames = new LinkedList<String>();
		long answer = 0;
		int index = 0;

		// Create Unsorted Name List
		for (String l : lines)
			for (String name : l.split(","))
				unsortedNames.add(name.replace("\"", ""));

		// Sort names alphabetically
		for (String name : unsortedNames)
		{
			int i = 0;

			for (String n : names)
				if (n.compareTo(name) < 0)
					i++;
				else
					break;

			if (i < names.size())
				names.add(i, name);
			else
				names.add(name);
		}

		// Do the problem
		for (String name : names)
		{
			long nameValue = 0;

			for (char c : name.toCharArray())
				nameValue += c - 'A' + 1;

			answer += nameValue * ++index;
		}

		return answer;
	}
}
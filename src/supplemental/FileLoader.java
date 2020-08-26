package supplemental;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

/**
 * A collection of file loading and saving helper methods.
 */
public class FileLoader
{
	/**
	 * Loads a file into a 2D single-digit Int array using LinkedList.
	 * @param path text file to be used. DIGITS ONLY
	 * @return 2D single-digit Int array
	 */
	public static List<LinkedList<Integer>> loadIntArray(String path)
	{
		LinkedList<LinkedList<Integer>> array = new LinkedList<LinkedList<Integer>>();
		List<String> file = loadLines(path);

		for (int y = 0; y < file.size(); y++)
		{
			array.add(new LinkedList<Integer>());

			for (int x = 0; x < file.get(y).length(); x++)
				array.get(y).add(Integer.parseInt(String.valueOf(file.get(y).charAt(x))));
		}

		return array;
	}

	/**
	 * Loads a file as a File, nothing more.
	 * @param path relative file path
	 * @return a simple reference to the file.
	 */
	public static File loadFile(String path)
	{
		URL url = new FileLoader().getClass().getResource(path);

		if (url == null)
			return null;
		else
			return new File(url.getPath());
	}

	/**
	 * Save a list of strings separated into a text document separated by line
	 * breaks
	 * @param path relative file path
	 * @param lines list of strings to be saved
	 */
	public static void saveLines(String path, List<String> lines)
	{
		PrintWriter pw = null;

		try
		{
			pw = new PrintWriter(loadFile(path));
		}
		catch (FileNotFoundException e)
		{}

		if (pw == null)
			return;

		// w.flush();
		for (String s : lines)
			pw.write(s + "\n");
		pw.close();
	}

	/**
	 * Load a list of strings separated by line breaks
	 * 
	 * @param path text file to be used
	 * @return a List<String> separated by line breaks
	 */
	public static List<String> loadLines(String path)
	{
		try
		{
			return Files.readAllLines(loadFile(path).toPath(), StandardCharsets.UTF_8);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Save a HashMap<String, String> to a file.
	 * @param path relative file path
	 * @param map HashMap to be saved
	 */
	public static void saveMap(String path, Map<String, String> map)
	{
		PrintWriter pw = null;

		try
		{
			pw = new PrintWriter(loadFile(path));
		}
		catch (FileNotFoundException e)
		{}

		if (pw == null)
			return;

		for (Map.Entry<String, String> entry : map.entrySet())
			pw.write(entry.getKey() + ":" + entry.getValue() + "\n");

		pw.close();
	}

	/**
	 * Load a HashMap<String, String> from a file.
	 * @param path relative file path
	 * @return loaded HashMap<String, String>
	 */
	public static Map<String, String> loadMap(String path)
	{
		try
		{
			Map<String, String> dic = new HashMap<String, String>();

			for (String line : Files.readAllLines(loadFile(path).toPath(), StandardCharsets.UTF_8))
			{
				String[] pair = line.split(":");

				if (pair.length == 2)
					dic.put(pair[0], pair[1]);
			}

			return dic;
		}
		catch (Exception e)
		{
			return null;
		}
	}
}

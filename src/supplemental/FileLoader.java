package supplemental;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

/**
 * An object to easily turn text files into data structures.
 */
public class FileLoader
{
  /**
   * Converts a file into a 2D single-digit Int array using LinkedList.
   * 
   * @param path  text file to be used. DIGITS ONLY
   * @return      2D single-digit Int array
   */
  public LinkedList<LinkedList<Integer>> loadIntArray(String path)
  {
    LinkedList<LinkedList<Integer>> array = new LinkedList<LinkedList<Integer>>();
    List<String> file = loadTextFile(path);
    
    for(int y = 0; y < file.size(); y++)
    {
      array.add(new LinkedList<Integer>());
      
      for(int x = 0; x < file.get(y).length(); x++)
        array.get(y).add(Integer.parseInt(String.valueOf(file.get(y).charAt(x))));
    }
    
    return array;
  }
  
  /**
   * Loads a file, doesn't process it in any way.
   * 
   * @param path  text file to be used
   * @return      a plain ol' File
   */
  public File loadFile(String path)
  {
    URL url = getClass().getResource(path);
    
    if(url == null)
      return null;
    else
      return new File(url.getPath());
  }
  
  public void saveTextFile(String path, List<String> text)
  {
    PrintWriter pw = null;
    
    try{pw = new PrintWriter(loadFile(path));}
    catch (FileNotFoundException e){}
    
    if(pw == null)
      return;

    //w.flush();
    for(String s: text)
      pw.write(s + "\n");
    pw.close();
  }
  
  /**
   * A quick way to turn a file into a string list.
   * 
   * @param path  text file to be used
   * @return      a String List where each index is a new line.
   */
  public List<String> loadTextFile(String path)
  {
    try{return Files.readAllLines(loadFile(path).toPath(), StandardCharsets.UTF_8);}
    catch (IOException e){e.printStackTrace();}

    return null;
  }
}

package problems;

import java.util.*;

import supplemental.FileLoader;

public class P_013 extends P_0
{
  public long run()
  {
    FileLoader fl = new FileLoader();
    List<String> lines = fl.loadTextFile("/files/P_013.txt");
    double answer = 0;
    
    for(String l: lines)
      answer += Double.parseDouble(l);
    
    return Long.parseLong(String.format("%10.0f", answer).substring(0, 10));
  }
}

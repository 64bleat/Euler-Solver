package problems;

import java.util.*;

import supplemental.FileLoader;

public class P_042 extends P_0
{
  static List<Integer> triList;
  
  public long run()
  {
    long answer = 0;
    FileLoader fl = new FileLoader();
    List<String> part1 = fl.loadTextFile("/files/P_42.txt");  //separated by lines (text file is a single line)
    List<String> part2 = new LinkedList<String>();            //separated by commas (text still surrounded by qoutes
    
    //strip quotes
    for(String a: part1)
      for(String b: a.split(","))
        part2.add(b.substring(1, b.length() - 1));
    
    //check if every word has a triangular sum
    for(String s: part2)
      if(isTri(wordSum(s)))
        answer++;
    
    return answer;
  }
  
  //convert words to integer sums
  private static int wordSum(String s)
  {
    int n = 0;
    
    for(char c: s.toCharArray())
      n += c - 'A' + 1;
    
    return n;
  }
  
  //produce triangular numbers
  private static int getTri(int n)
  {
    if(n < 1)
      return -1;
    
    if(triList == null)
      triList = new ArrayList<Integer>();
    
    while(triList.size() < n)
      triList.add((triList.size() + 1) * (triList.size() + 2) / 2);
   
    return triList.get(n-1);
  }
  
  //check if a number is triangular
  private static boolean isTri(int t)
  {
    int n = 1;
    
    while(getTri(n) < t)
      n++;
    
    return triList.get(n-1) == t;
  }
  
}

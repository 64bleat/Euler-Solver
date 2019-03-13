package problems;

public class P_001 extends P_0
{
  public long run()
  {
    Integer[] next = {3, 2, 1, 3, 1, 2, 3};
    int answer = 0, n = 0, i = 0;
    
    while((n += next[i++ % next.length]) < 1000)
      answer += n;
    
    return answer;
  }
}

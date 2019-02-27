/* ===========================================================================================================================
 * PERMUTATION ALGORITHM
 *  1. Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
 *  2. Find the largest index l greater than k such that a[k] < a[l].
 *  3. Swap the value of a[k] with that of a[l].
 *  4. Reverse the sequence from a[k + 1] up to and including the final element a[n].
 * ===========================================================================================================================*/
 package problems;

public class P_024 extends P_0
{
  public long run()
  {
    int set[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    String answer = "";
    
    for(long p = 1; p < 1000000; p++)
    {
      int k = set.length - 2;
      int l = set.length - 1;
      
      while(k >= 0 && set[k] > set[k+1])
        k--;
      
      if(k < 0)
        break;
      
      while(l > k && set[k] > set[l])
        l--;
      
      swap(k,l,set);
      
      l = set.length;
      while(++k < --l)
        swap(k, l, set);
    }
    
    for(int i: set)
      answer += i;

    return Long.parseLong(answer);
  }
  
  private static void swap(int a, int b, int[] set)
  {
    int temp = set[a];
    set[a] = set[b];
    set[b] = temp;
  }
}

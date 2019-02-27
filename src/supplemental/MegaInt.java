package supplemental;

public class MegaInt implements Comparable<MegaInt>
{
  private Digit ones;
  
  public MegaInt add(MegaInt n)
  {
    Digit iA = ones;
    Digit iB = n.ones;
    
    while(iB != null)
    {      
      iA.add(iB);
      
      if((iB = iB.next) == null)
        break;
      
      if(iA.next == null) 
        iA.next = new Digit(0);

      iA = iA.next;
    }
    
    return this;
  }
  
  public MegaInt multiplyBy(int n)
  {
    MegaInt original = new MegaInt(toString());
    
    while(n-- > 1)
      add(original);
    
    return this;
  }
  
  public MegaInt powerOf(int n)
  {
    MegaInt original = new MegaInt(toString());
    
     while(n-- > 1)
       multiplyBy(Integer.parseInt(original.toString()));
     
     return this;
  }
  
  public long length()
  {
    long l = 1;
    Digit d = ones;
    
    while((d = d.next) != null)
      l++;
    
    return l;
  }
  
  public int compareTo(MegaInt arg0)
  {
    long a, b;
    
    if(arg0 == null)
      return 1;
    else if((a = length()) != (b = arg0.length()))
      return (int)(a - b);
    else
      return toString().compareTo(arg0.toString());
  }
  
  public String toString()
  {
    return ones.toString();
  }
  
  public MegaInt(int n)
  {
    this(""+n);
  }
  
  public MegaInt(String s)
  {
    ones = new Digit(s);
  }
  
  private class Digit
  {
    int value;
    Digit next;
    
    public void add(Digit b)
    {
      int newVal = value + b.value;
      
      value = newVal % 10;
      
      if((newVal /= 10) != 0)
        if(next != null)
          next.add(new Digit(newVal));
        else
          next = new Digit(newVal);
    }
    
    public String toString()
    {
      if(next != null)
        return "" + next + value;
      else
        return "" + value;
    }
    
    public Digit(int n)
    {      
      value = (n % 10);
      
      if((n /= 10) != 0)
        next = new Digit(n);
    }
    
    public Digit(String s)
    {
      value = Integer.parseInt("" + s.charAt(s.length() - 1));
      
      s = s.substring(0, s.length() - 1);
      
      if(s.length() > 0)
        next = new Digit(s);
    }
  }
}

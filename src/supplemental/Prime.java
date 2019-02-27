package supplemental;

import java.util.*;

public class Prime
{
  private Map<Long, List<Long>> factors;
  private Map<Integer, Long> perfects, primes;
  private int cursor;
  
  /*============================================================
   * ABUNDANCE
   * =========================================================*/
  public long abundanceOf(long number)
  {
    long abundance = 0;
   
    for(Long n: properDivisorsOf(number)) 
      abundance += n;
    
    return abundance - number;
  }
  
  /*============================================================
   * AMICABILITY
   * =========================================================*/
  public boolean areAmicable(long a, long b)
  {
    long dA = 0;
    long dB = 0;
    
    for(Long l: properDivisorsOf(a)) dA += l;
    for(Long l: properDivisorsOf(b)) dB += l;
    
    return a != b && dA == b && dB == a;
  }
  
  /*============================================================
   * FULL FACTORING
   * =========================================================*/  
  public List<Long> factor(long number)
  {
    List<Long> fGet = factors.get(number);
    double numberSqrt = Math.sqrt(number);
    
    if(number < 1)
      return new LinkedList<Long>();
    else if (fGet != null)
      return fGet;
    else
      fGet = new LinkedList<Long>();
    
    fGet.add(1L);
    
    if(number > 1)
      fGet.add(number);
    
    for(long divisor = 2; divisor <= numberSqrt; divisor++)
    {
      if(number % divisor == 0)
      {
        long dividend = number / divisor;
        LinkedList<Long> fDup = new LinkedList<Long>();
        LinkedList<Long> fDub = new LinkedList<Long>();
        
        fGet = factor(dividend);
        
        for(Long l: fGet)
        {
          fDup.add(l);
          fDub.add(l * divisor);
        } 
        
        sortnumberloop:
        while(!fDub.isEmpty())
        {
          long newF = fDub.remove();
          int i = 0;
          
          for(Long l: fDup)
            if(l < newF) 
              i++;
            else if(l == newF) 
              continue sortnumberloop;
            else 
              break;
          
          if(i < fDup.size())
            fDup.add(i, newF);
          else
            fDup.add(newF);
        }
        
        factors.put(number, fDup);
        return fDup;
      }
    }
    
    factors.put(number, fGet);
    return fGet;  
  }
  
  /*============================================================
   * GREATEST COMMON FACTOR
   * =========================================================*/
  public long gcf(long a, long b)
  {
    List<Long> fA, fB;
    long gcf = 0;

    fA = factor(a);
    fB = factor(b);
    
    for(Long x: fA)
      for(Long y: fB)
        if(x == y && x > gcf)
          gcf = x;
    
    return gcf;
  }
  
  /*============================================================
   * GETTING PRIMES
   * =========================================================*/
  public long get(int index)
  {
    while(primes.size() <= index)
    {
      long newPrime = primes.get(primes.size() - 1);
      
      primesearchloop:
      while(true)
      {
        newPrime += 2;
        double newPrimeSqrt = Math.sqrt(newPrime);
        long primeX;
        
        for(int i = 0; (primeX = primes.get(i)) <= newPrimeSqrt; i++)
          if(newPrime % primeX == 0)
            continue primesearchloop;
        
        break primesearchloop;
      }
      
      primes.put(primes.size(), newPrime);
    }
  
    
    return primes.get(index);
  }
  
  /*============================================================
   * IS PRIME
   * =========================================================*/
  public boolean isPrime(long n)
  {
    long check = 0;
    
    for(int i = 0; (check = get(i)) <= n; i++)
      if(check == n)
        return true;
      
    return false;
  }
  
  /*============================================================
   * NEXT
   * =========================================================*/
  public long next()
  {
    return get(cursor++);
  }
  
  /*============================================================
   * SMALLEST PERFECTLY DIVISIBLE NUMBER
   * =========================================================*/
  public long perfectTo(int num)
  {
    while(perfects.size() <= num)
      perfects.put(perfects.size(), perfects.get(perfects.size() - 1) * perfects.size() / gcf(perfects.get(perfects.size() - 1), perfects.size()));
    
    return perfects.get(num); 
  }
  
  /*============================================================
   * PRIME FACTORING BREAKDOWN
   * =========================================================*/ 
  public LinkedList<Long> primeFactor(long number)
  {
    LinkedList<Long> factors = new LinkedList<Long>();
    long remainder = number;
    double remainderSqrt = Math.sqrt(remainder);
    long primeIndex;
    boolean notPrime = true;
    
    while(notPrime)
    {
      notPrime = false;
      
      for(int i = 0; !notPrime && (primeIndex = get(i)) <= remainderSqrt; i++)
        if(notPrime = remainder % primeIndex == 0)
        {
          remainder /= primeIndex;
          factors.add(primeIndex);
        }
    }
    
    if(remainder > 1)
      factors.add(remainder);
    
    return factors;    
  }
  
  /*============================================================
   * PROPER DIVISORS
   * =========================================================*/
  public LinkedList<Long> properDivisorsOf(long n)
  {
    LinkedList<Long> pFactors = new LinkedList<Long>();
    
    for(Long l: factor(n))
      if(l < n )
        pFactors.add(l);
    
    return pFactors;
  }
  
  /*============================================================
   * RESET
   * =========================================================*/
  public void reset()
  {
    cursor = 0;
  }
  
  /*============================================================
   * Constructor
   * =========================================================*/
  public Prime()
  {
    primes = new HashMap<Integer, Long>();
    primes.put(0, 2L);
    primes.put(1, 3L);
    cursor = 0;
    
    perfects = new HashMap<Integer, Long>();
    perfects.put(0, 0L);
    perfects.put(1, 1L);
    
    factors = new HashMap<Long, List<Long>>();
  }
}
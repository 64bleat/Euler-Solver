package supplemental;

import java.util.*;

/**
 * Prime Numbers. A tool class for handling prime number-related solutions.
 * Prime numbers take a lot of time to compute, so it is wise to store some
 * information in memory.
 * 
 * @see <a href = https://en.wikipedia.org/wiki/Prime_number> Wikipedia: Prime
 *      number </a>
 * @see supplemental.Prime#get(int)
 */
public class Prime
{
	private static int cursor = 0;
	private static Map<Long, Long[]> savedFactors = new HashMap<Long, Long[]>();
	private static Map<Integer, Long> perfects = new HashMap<Integer, Long>()
	{
		{
			put(0, 0L);
			put(1, 1L);
		}
	};

	private static Map<Integer, Long> primes = new HashMap<Integer, Long>()
	{
		{
			put(0, 2L);
			put(1, 3L);
		}
	};

	/**
	 * Abundance. The sum of all proper divisors of an integer.
	 * 
	 * @param number any positive integer
	 * @return the abundance of number
	 * @see <a href = "https://en.wikipedia.org/wiki/Abundant_number">
	 *      Wikipedia: Abundant Number </a>
	 */
	public static long abundanceOf(long number)
	{
		long abundance = -number;

		for (Long n : factorize(number))
			abundance += n;

		return abundance;
	}

	/**
	 * Amicability
	 * 
	 * Amicable numbers are two different numbers related in such a way that the
	 * sum of the proper divisors of each is equal to the other number.
	 * 
	 * @param a any positive integer
	 * @param b any positive integer
	 * @return true if a and b are amicable
	 * @see <a href = "https://en.wikipedia.org/wiki/Amicable_numbers">
	 *      Wikipedia: Amicable Numbers </a>
	 * 
	 */
	public static boolean areAmicable(long a, long b)
	{
		return a != b && abundanceOf(a) == b && abundanceOf(b) == a;
	}

	/**
	 * Factorization
	 * @param n any positive integer
	 * @return all possible divisors for an integer
	 * @see <a href = https://en.wikipedia.org/wiki/Factorization> Wikipedia:
	 *      Factorization </a>
	 */
	public static Long[] factorize(long n)
	{
		Long[] fArray = savedFactors.get(n);

		if (fArray != null)
			return fArray;
		else if (n < 1)
			return new Long[0];

		for (long divisor = 2, sqrt = (long) Math.sqrt(n); divisor <= sqrt; divisor++)
			if (n % divisor == 0)
			{
				SortedSet<Long> factors = new TreeSet<Long>();
				
				for (Long f : factorize(n / divisor))
				{
					factors.add(f);
					factors.add(f * divisor);
				}

				fArray = factors.toArray(new Long[factors.size()]);
				savedFactors.put(n, fArray);
				return fArray;
			}

		fArray = new Long[] {1L, n};
		savedFactors.put(n, fArray);
		return fArray;
	}

	/**
	 * Greatest Common Divisor. The largest positive integer that divides each
	 * of the integers
	 * 
	 * @param a any positive integer
	 * @param b any positive integer
	 * @return the greatest common divisor between a and b.
	 * @see <a href = "https://en.wikipedia.org/wiki/Greatest_common_divisor">
	 *      Wikipedia: Greatest Common Divisor </a>
	 */
	public static long gcd(long a, long b)
	{
		Long[] fA = factorize(a);
		Long[] fB = factorize(b);
		int i = fA.length - 1;
		int j = fB.length - 1;

		while (i >= 0 && j >= 0)
			if (fA[i] == fB[j])
				return fA[i];
			else if (fA[i] > fB[j])
				i--;
			else
				j--;

		return 1L;
	}

	/**
	 * In the list of all prime numbers, each number has its own index. The
	 * prime number, 1, is at index 0.
	 * 
	 * @param index the index of the desired prime number
	 * @return the prime number at the provided index
	 */
	public static long get(int index)
	{
		while (primes.size() <= index)
		{
			long newPrime = primes.get(primes.size() - 1);

			primesearchloop:
			while (true)
			{
				newPrime += 2;
				double newPrimeSqrt = Math.sqrt(newPrime);
				long primeX;

				for (int i = 0; (primeX = primes.get(i)) <= newPrimeSqrt; i++)
					if (newPrime % primeX == 0)
						continue primesearchloop;

				break primesearchloop;
			}

			primes.put(primes.size(), newPrime);
		}

		return primes.get(index);
	}

	/**
	 * Is n Prime?
	 * @param n any positive integer.
	 * @return true if n is prime.
	 */
	public static boolean isPrime(long n)
	{
		long check = 0;

		for (int i = 0; (check = get(i)) <= n; i++)
			if (check == n)
				return true;

		return false;
	}

	/**
	 * Iterate through prime numbers
	 * 
	 * @return the prime number at the internal index cursor.
	 * @see supplemental.Prime#reset()
	 */
	public static long next()
	{
		return get(cursor++);
	}

	/**
	 * Smallest Perfect Multiple
	 * 
	 * @param n the maximum integer in which the result is divisible by.
	 * @return the smallest positive number that is divisible by every number
	 *         from 1 to n.
	 */
	public static long perfectTo(int n)
	{
		while (perfects.size() <= n)
			perfects.put(perfects.size(), perfects.get(perfects.size() - 1) * perfects.size()
					/ gcd(perfects.get(perfects.size() - 1), perfects.size()));

		return perfects.get(n);
	}

	/**
	 * Decompose a positive integer into its prime factors
	 * @param n any positive integer
	 * @return a list of prime factor components
	 * @see <a href = "https://en.wikipedia.org/wiki/Integer_factorization">
	 *      Wikipedia: Integer Factorization </a>
	 */
	public static LinkedList<Long> primeFactorize(long n)
	{
		LinkedList<Long> factors = new LinkedList<Long>();
		long remainder = n;
		double remainderSqrt = Math.sqrt(remainder);
		long primeIndex;
		boolean notPrime = true;

		while (notPrime)
		{
			notPrime = false;

			for (int i = 0; !notPrime && (primeIndex = get(i)) <= remainderSqrt; i++)
				if (notPrime = remainder % primeIndex == 0)
				{
					remainder /= primeIndex;
					factors.add(primeIndex);
				}
		}

		if (remainder > 1)
			factors.add(remainder);

		return factors;
	}

	/**
	 * A positive proper divisor is a positive divisor of a number n, excluding
	 * n itself.
	 * @param n any positive integer
	 * @return a set of proper divisors for n
	 * @see <a href = "https://mathworld.wolfram.com/ProperDivisor.html">
	 *      Wolfram: Proper Divisor </a>
	 */
	public static Long[] properDivisorsOf(long n)
	{
		LinkedList<Long> pFactors = new LinkedList<Long>();

		for (Long l : factorize(n))
			if (l < n)
				pFactors.add(l);

		return pFactors.toArray(new Long[pFactors.size()]);
	}

	/**
	 * Resets the prime index cursor to 0.
	 * @see supplemental.Prime#next()
	 */
	public static void reset()
	{
		cursor = 0;
	}
}
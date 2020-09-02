/*
 * ============================================================================
 * byte 2^7 short 2^15 < 32768 int 2^31 < 2147483648 long 2^63
 * =========================================================================
 */

package supplemental;

import java.util.LinkedList;

/**
 * An arbitrarily large integer class.
 */
public class SuperNumber implements Comparable<SuperNumber>
{
	private final long threshold = 1000000000L;
	private boolean negative;
	private LinkedList<Integer> number;
	
	// Constructors
	public SuperNumber()
	{
		this(0L);
	}

	public SuperNumber(int n)
	{
		this((long) n);
	}

	public SuperNumber(long n)
	{
		number = new LinkedList<Integer>();

		if (n < 0)
		{
			negative = true;
			n *= -1;
		}
		else
			negative = false;

		number.add(0, (int) (n % threshold));

		while ((n /= threshold) > 0)
			number.add((int) (n % threshold));
	}

	// Set
	public SuperNumber set(int n)
	{
		set((long) n);

		return this;
	}

	public SuperNumber set(long n)
	{
		set(new SuperNumber(n));

		return this;
	}

	public SuperNumber set(SuperNumber sn)
	{
		number = sn.copy().number;
		negative = sn.negative;

		return this;
	}

	// Add
	public SuperNumber add(int i)
	{
		add((long) i);

		return this;
	}

	public SuperNumber add(long i)
	{
		add(new SuperNumber(i));

		return this;
	}

	public SuperNumber add(SuperNumber b)
	{
		if (b.negative == true)
		{
			b.negative = false;
			subtract(b);
			b.negative = true;
		}
		else if (negative == true)
		{
			boolean now = (compareTo(b) <= 0) ? false : true;

			negative = false;
			subtract(b);
			negative = now;
		}
		else
		{
			int cb = 0;
			long total = 0;

			while (cb < b.size() || total != 0)
			{
				// ensure
				while (size() <= cb)
					number.add(0);
				// add
				total += (long) getIndex(cb) + (long) b.getIndex(cb);
				// change
				number.set(cb, (int) (total % threshold));
				// carry overflow
				total /= threshold;
				// next
				cb++;
			}
		}

		return this;
	}

	// Subtract
	public SuperNumber subtract(int n)
	{
		subtract((long) n);

		return this;
	}

	public SuperNumber subtract(long n)
	{
		subtract(new SuperNumber(n));

		return this;
	}

	public SuperNumber subtract(SuperNumber b)
	{
		if (b.negative == true)
		{
			b.negative = false;
			add(b);
			b.negative = true;
		}
		else if (negative == true)
		{
			negative = false;
			add(b);

			if (isNonZero())
				negative = true;
		}
		else if (compareTo(b) == 0)
		{
			negative = false;
			set(0);
		}
		else if (compareTo(b) < 0)
		{
			set(b.copy().subtract(this));
			negative = true;
		}
		else
		{
			int cb = 0;

			while (cb < b.size())
			{
				long iA = getIndex(cb);
				long iB = b.getIndex(cb);

				// carry
				if (iA < iB)
				{
					number.set(cb + 1, getIndex(cb + 1) - 1);
					iA += threshold;
				}

				// subtract and set;
				number.set(cb, (int) (iA - iB));

				cb++;
			}

			// trim dead space
			cb = size() - 1;

			while (getIndex(cb) == 0 && cb != 0)
				number.remove(cb);
		}
		return this;
	}

	// Multiply
	public SuperNumber multiply(int n)
	{
		multiply((long) n);

		return this;
	}

	public SuperNumber multiply(long n)
	{
		multiply(new SuperNumber(n));

		return this;
	}

	public SuperNumber multiply(SuperNumber b)
	{
		SuperNumber ns = new SuperNumber();
		int cb = 0;

		while (cb < b.size())
		{
			SuperNumber part = new SuperNumber();
			int ca = 0;
			long total = 0;

			while (ca < size() || total > 0)
			{
				total += (long) getIndex(ca) * (long) b.getIndex(cb);

				while (part.size() <= ca)
					part.number.add(0);

				part.number.set(ca, (int) (total % threshold));

				total /= threshold;

				ca++;
			}

			part.shiftUp(cb);
			ns.add(part);
			cb++;
		}

		number = ns.number;

		if (b.negative)
			negative = !negative;

		return this;
	}

	// Exponents
	public SuperNumber powerOf(int i)
	{
		SuperNumber copy = copy();

		while (i-- > 1)
			multiply(copy);

		return this;
	}

	public SuperNumber powerOf(SuperNumber ns)
	{
		SuperNumber copy = copy();
		ns = ns.copy();

		while (ns.subtract(1).isPositive())
			multiply(copy);

		return this;
	}

	// Shifting
	public SuperNumber shiftUp(int i)
	{
		while (i-- > 0)
			shiftUp();

		return this;
	}

	public SuperNumber shiftUp()
	{
		number.addFirst(0);

		return this;
	}

	public SuperNumber shiftDown()
	{
		if (size() > 1)
			number.removeFirst();
		else
			number.set(0, 0);

		return this;
	}

	// Tools
	public boolean isNonZero()
	{
		if (size() > 1)
			return true;
		else if (getIndex(0) != 0)
			return true;
		else
			return false;
	}

	public boolean isPositive()
	{
		return !negative;
	}

	private SuperNumber copy()
	{
		SuperNumber sn = new SuperNumber();
		sn.number = new LinkedList<Integer>();

		for (Integer i : number)
			sn.number.add(i);

		return sn;
	}

	private int getIndex(int i)
	{
		if (i < number.size())
			return number.get(i);
		else
			return 0;
	}

	private int size()
	{
		return number.size();
	}

	// Comparable
	public int compareTo(SuperNumber o)
	{
		if (size() != o.size())
			return size() - o.size();
		else
			for (int c = size() - 1; c >= 0; c--)
				if (getIndex(c) - o.getIndex(c) > 0)
					return 1;
				else if (getIndex(c) - o.getIndex(c) < 0)
					return -1;

		return 0;
	}

	// String
	public String toString()
	{
		String s = "";
		int cursor = number.size() - 1;

		if (negative)
			s += "-";

		while (cursor >= 0)
		{
			s += number.get(cursor);

			if (cursor > 0)
			{
				int zeroes = 8;
				int check = getIndex(cursor - 1);

				while ((check /= 10) != 0)
					zeroes--;

				while (zeroes-- > 0)
					s += "0";
			}

			cursor--;
		}

		return s;
	}
}
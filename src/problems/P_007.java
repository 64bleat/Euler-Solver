package problems;

import supplemental.Prime;

/**
 * <b>10001st Prime</b><br>
 * My indexing system starts at 0 instead of 1, so it is 1 off.
 * @see supplemental.Prime
 */
public class P_007 extends P_0
{
	public long run()
	{
		return Prime.get(10000);
	}
}

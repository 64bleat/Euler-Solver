package problems;

/**
 * Sum Square Difference.
 * 
 * Find the difference between the sum of the squares of the first 100 natural
 * numbers and square the sum. Confusing enough?
 */
public class P_006 extends P_0
{
	public long run()
	{
		long answer, sumOfSquares, squareOfSum;

		squareOfSum = 100 * 100 / 2 + 100 / 2;
		squareOfSum *= squareOfSum;
		sumOfSquares = 0;

		for (long i = 1; i <= 100; i++)
			sumOfSquares += i * i;

		answer = squareOfSum - sumOfSquares;

		return answer;
	}
}

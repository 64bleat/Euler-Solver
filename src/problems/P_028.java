package problems;

/**
 * <b>Number spiral diagonals</b><br>
 */
public class P_028 extends P_0
{
	public long run()
	{
		long answer = 1;
		long cursor = 1;

		for (int i = 3; i <= 1001; i += 2)
			for (int c = 0; c < 4; c++)
				answer += (cursor += i - 1);

		return answer;
	}
}

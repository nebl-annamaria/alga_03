import java.util.Arrays;
import java.util.Scanner;

public class RemovalGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		sc.nextLine();

		String line = sc.nextLine();

		String[] digits = line.split(" ");
		long[] numbers = Arrays.stream(digits).mapToLong(Long::parseLong).toArray();

		System.out.println(RemovalGame.maxScore(numbers));
	}

	public static long maxScore(long[] numbers) {
		int n = numbers.length;
		long[][] dp = new long[n][n];

		for (int i = 0; i < n; i++) {
			dp[i][i] = numbers[i];
		}

		for (int length = 2; length <= n; length++) {
			for (int i = 0; i <= n - length; i++) {
				int j = i + length - 1;
				long takeLeft = numbers[i] + Math.min(
						i + 2 <= j ? dp[i + 2][j] : 0,
						i + 1 <= j - 1 ? dp[i + 1][j - 1] : 0
				);
				long takeRight = numbers[j] + Math.min(
						i <= j - 2 ? dp[i][j - 2] : 0,
						i + 1 <= j - 1 ? dp[i + 1][j - 1] : 0
				);
				dp[i][j] = Math.max(takeLeft, takeRight);
			}
		}

		return dp[0][n - 1];
	}
}

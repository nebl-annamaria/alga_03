public class RemovalGame {

	public long maxScore(long[] numbers) {
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

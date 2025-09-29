class Solution {
    public int minScoreTriangulation(int i, int j, int[] values, int[][] dp) {
        if (j - i <= 1) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int mini = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int val = values[i] * values[k] * values[j] + minScoreTriangulation(i, k, values, dp) + minScoreTriangulation(k, j, values, dp);
            mini = Math.min(mini, val);
        }
        return dp[i][j] = mini;
    }

    public int minScoreTriangulation(int[] values) {
        int n = values.length;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return minScoreTriangulation(0, n - 1, values, dp);
    }
}
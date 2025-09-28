class Solution {
    public int uniquePaths(int i, int j, int m, int n, int[][] dp) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int right = 0;
        if (j + 1 < n) {
            right = uniquePaths(i, j + 1, m, n, dp);
        }
        int down = 0;
        if (i + 1 < m) {
            down = uniquePaths(i + 1, j, m, n, dp);
        }

        return dp[i][j] = down + right;
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return uniquePaths(0, 0, m, n, dp);
    }
}
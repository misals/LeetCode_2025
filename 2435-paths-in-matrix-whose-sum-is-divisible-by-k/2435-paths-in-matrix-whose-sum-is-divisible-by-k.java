class Solution {
    int MOD = 1000000007;

    public int solve(int i, int j, int sum, int[][] grid, int k, int[][][] dp) {
        int n = grid.length, m = grid[0].length;

        // If reached bottom-right
        if (i == n - 1 && j == m - 1) {
            int finalSum = (sum + grid[i][j]) % k;
            return finalSum == 0 ? 1 : 0;
        }

        if (i >= n || j >= m) return 0;

        if (dp[i][j][sum] != -1) return dp[i][j][sum];

        int newSum = (sum + grid[i][j]) % k;

        int right = solve(i, j + 1, newSum, grid, k, dp);
        int down  = solve(i + 1, j, newSum, grid, k, dp);

        return dp[i][j][sum] = (right + down) % MOD;
    }

    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;

        int[][][] dp = new int[n][m][k];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                Arrays.fill(dp[i][j], -1);

        return solve(0, 0, 0, grid, k, dp);
    }
}

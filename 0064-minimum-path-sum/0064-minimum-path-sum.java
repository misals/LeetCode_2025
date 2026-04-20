class Solution {
    public int minPathSum(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0) {
            return grid[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int left = Integer.MAX_VALUE;
        if (j - 1 >= 0) {
            left = grid[i][j] + minPathSum(i, j - 1, grid, dp);
        }
        int up = Integer.MAX_VALUE;
        if (i - 1 >= 0) {
            up = grid[i][j] + minPathSum(i - 1, j, grid, dp);
        }

        return dp[i][j] = Math.min(left, up);
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return minPathSum(n - 1, m - 1, grid, dp);
    }
}
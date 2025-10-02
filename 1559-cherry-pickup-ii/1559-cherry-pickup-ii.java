class Solution {
    public int cherryPick(int i, int c1, int c2, int n, int m, int[][] grid, int[][][] dp) {
        if (c1 < 0 || c2 < 0 || c1 >= m || c2 >= m) {
            return Integer.MIN_VALUE;
        }

        if (i == n - 1) {
            if (c1 == c2) {
                return grid[i][c1];
            } else {
                return grid[i][c1] + grid[i][c2];
            }
        }

        if (dp[i][c1][c2] != -1) {
            return dp[i][c1][c2];
        }

        int maxi = Integer.MIN_VALUE;

        for (int x = c1 - 1; x <= c1 + 1; x++) {
            for (int y = c2 - 1; y <= c2 + 1; y++) {
                int val = 0;
                if (c1 == c2) {
                    val = grid[i][c1];
                } else {
                    val = grid[i][c1] + grid[i][c2];
                }
                val += cherryPick(i + 1, x, y, n, m, grid, dp);
                maxi = Math.max(maxi, val);
            }
        }
        return dp[i][c1][c2] = maxi;
    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return cherryPick(0, 0, m - 1, n, m, grid, dp);
    }
}
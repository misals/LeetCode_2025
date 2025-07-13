class Solution {
    public int paintWalls(int ind, int remaining, int[] cost, int[] time, int[][] dp) {
        if (remaining <= 0) {
            return 0;
        }
        if (ind < 0) return 2000000000;

        if (dp[ind][remaining] != -1) return dp[ind][remaining];

        int notPaint = paintWalls(ind - 1, remaining, cost, time, dp);
        int paint = cost[ind] + paintWalls(ind - 1, remaining - 1 - time[ind], cost, time, dp);

        return dp[ind][remaining] = Math.min(notPaint, paint);
    }

    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;

        int[][] dp = new int[n][n+1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return paintWalls(n - 1, n, cost, time, dp);
    }
}
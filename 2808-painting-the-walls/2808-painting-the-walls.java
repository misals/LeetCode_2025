class Solution {
    public int paintWalls(int ind, int remaining, int[] cost, int[] time, int[][] dp) {
        if (remaining <= 0) {
            return 0;
        }
        if (ind < 0) {
            return (int)1e9;
        }
        if (dp[ind][remaining] != -1) {
            return dp[ind][remaining];
        }

        int notPick = paintWalls(ind - 1, remaining, cost, time, dp);
        int pick = cost[ind] + paintWalls(ind - 1, remaining - 1 - time[ind], cost, time, dp);

        return dp[ind][remaining] = Math.min(pick, notPick);
    }

    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;

        int[][] dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return paintWalls(n - 1, n, cost, time, dp);
    }
}
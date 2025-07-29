class Solution {
    public int coinChange(int ind, int amount, int[] coins, int[][] dp) {
        if (amount == 0) {
            return 1;
        }
        if (ind == 0) {
            if (amount % coins[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[ind][amount] != -1) return dp[ind][amount];

        int notTake = coinChange(ind - 1, amount, coins, dp);
        int take = 0;
        if (amount >= coins[ind]) {
            take = coinChange(ind, amount - coins[ind], coins, dp);
        }

        return dp[ind][amount] = take + notTake;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return coinChange(n - 1, amount, coins, dp);
    }
}
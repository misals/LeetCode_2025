class Solution {
    public int coinChange(int i, int amount, int[] coins, int[][] dp) {
        if (amount == 0) {
            return 1;
        }
        if (i == 0) {
            if (amount % coins[i] == 0) {
                return 1;
            }
            return 0;
        }

        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }
        int notTake = coinChange(i - 1, amount, coins, dp);
        int take = 0;
        if (amount >= coins[i]) {
            take = coinChange(i, amount - coins[i], coins, dp);
        }

        return dp[i][amount] = take + notTake;
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
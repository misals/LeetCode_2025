class Solution {
    public int coinChange(int ind, int amount, int[] coins, int[][] dp) {
        if (ind == 0) {
            if (amount % coins[ind] == 0) {
                return amount / coins[ind];
            } else {
                return (int)1e9;
            }
        }
        if (dp[ind][amount] != -1) return dp[ind][amount];

        int notPick = coinChange(ind - 1, amount, coins, dp);
        int pick = Integer.MAX_VALUE;
        if (amount >= coins[ind]) {
            pick = 1 + coinChange(ind, amount - coins[ind], coins, dp);
        }

        return dp[ind][amount] = Math.min(pick, notPick);
        
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = coinChange(n - 1, amount, coins, dp);
        if (ans >= 1e9) {
            return -1;
        }
        return ans;
    }
}
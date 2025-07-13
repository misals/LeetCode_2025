class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        
        for (int tar = 0; tar <= amount; tar++) {
            if (tar % coins[0] == 0) {
                dp[0][tar] = tar / coins[0];
            } else {
                dp[0][tar] = (int)1e9;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int tar = 0; tar <= amount; tar++) {
                int notPick = dp[i - 1][tar];
                int pick = Integer.MAX_VALUE;
                if (tar >= coins[i]) {
                    pick = 1 + dp[i][tar - coins[i]];
                }
                dp[i][tar] = Math.min(pick, notPick);
            }
        }

        return dp[n-1][amount] >= 1e9 ? -1 : dp[n-1][amount];
    }
}
class Solution {
    public int change(int ind, int tar, int[] coins, int[][] dp) {
        if (ind == 0) {
            if (tar % coins[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[ind][tar] != -1) return dp[ind][tar];

        int notPick = change(ind - 1, tar, coins, dp);
        int pick = 0;
        if (tar >= coins[ind]) {
            pick = change(ind, tar - coins[ind], coins, dp);
        }

        return dp[ind][tar] = pick + notPick;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return change(n - 1, amount, coins, dp);
    }
}
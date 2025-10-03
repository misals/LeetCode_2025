class Solution {
    public int maxProfit(int ind, int buy, int n, int tran, int[] prices, int[][][] dp) {
        if (tran == 0 || ind == n) {
            return 0;
        }

        if (dp[ind][buy][tran] != -1) {
            return dp[ind][buy][tran];
        }

        int profit = 0;
        if (buy == 0) {
            profit = Math.max(-prices[ind] + maxProfit(ind + 1, 1, n, tran, prices, dp),
                                            maxProfit(ind + 1, 0, n, tran, prices, dp));
        } else {
            profit = Math.max(prices[ind] + maxProfit(ind + 1, 0, n, tran - 1, prices, dp),
                                            maxProfit(ind + 1, 1, n, tran, prices, dp));
        }

        return dp[ind][buy][tran] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n][2][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return maxProfit(0, 0, n, 2, prices, dp);
    }
}
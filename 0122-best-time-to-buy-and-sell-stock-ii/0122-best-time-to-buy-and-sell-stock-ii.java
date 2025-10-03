class Solution {
    public int maxProfit(int ind, int tran, int n, int[] prices, int[][] dp) {
        if (ind == n) {
            return 0;
        }

        if (dp[ind][tran] != -1) {
            return dp[ind][tran];
        }

        int profit = 0;
        if (tran == 0) {
            profit = Math.max(-prices[ind] + maxProfit(ind + 1, 1, n, prices, dp),
                                            maxProfit(ind + 1, 0, n, prices, dp));
        } else {
            profit = Math.max(prices[ind] + maxProfit(ind + 1, 0, n, prices, dp),
                                            maxProfit(ind + 1, 1, n, prices, dp));
        }
        return dp[ind][tran] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return maxProfit(0, 0, n, prices, dp);
    }
}
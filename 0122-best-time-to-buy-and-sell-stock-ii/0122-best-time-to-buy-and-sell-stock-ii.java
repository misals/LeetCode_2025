class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 1][2];
        
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy < 2; buy++) {
                if (buy == 0) {
                    dp[ind][buy] = Math.max(-prices[ind] + dp[ind + 1][1], dp[ind + 1][0]);
                } else {
                    dp[ind][buy] = Math.max(prices[ind] + dp[ind + 1][0], dp[ind + 1][1]);
                }
            }
        }

        return dp[0][0];
    }
}
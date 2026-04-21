class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] dp = new int[2];
        int[] curr = new int[2];
        
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy < 2; buy++) {
                if (buy == 0) {
                    curr[buy] = Math.max(-prices[ind] + dp[1], dp[0]);
                } else {
                    curr[buy] = Math.max(prices[ind] + dp[0], dp[1]);
                }
                dp = curr;
            }
        }

        return dp[0];
    }
}
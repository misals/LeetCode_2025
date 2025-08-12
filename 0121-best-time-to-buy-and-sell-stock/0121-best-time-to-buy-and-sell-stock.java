class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int mini = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - mini);
        }
        return maxProfit;
    }
}
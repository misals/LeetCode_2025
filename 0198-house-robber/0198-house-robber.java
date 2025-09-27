class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int notRob = 0;
            if (i - 1 >= 0) {
                notRob += dp[i - 1];
            }
            int rob = nums[i];

            if (i - 2 >= 0) {
                rob += dp[i - 2];
            }

            dp[i] = Math.max(notRob, rob);
        }

        return dp[n - 1];
    }
}
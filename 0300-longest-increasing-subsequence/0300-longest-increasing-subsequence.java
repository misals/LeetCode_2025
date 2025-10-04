class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int ans = 0;

        int[][] dp = new int[n + 1][n + 2];

        for (int ind = 1; ind <= n; ind++) {
            for (int prevInd = 0; prevInd <= n; prevInd++) {
                int notPick = dp[ind - 1][prevInd];
                int pick = 0;

                if (prevInd == n || nums[ind - 1] < nums[prevInd]) {
                    pick = 1 + dp[ind - 1][ind - 1];
                }

                dp[ind][prevInd] = Math.max(pick, notPick);
            }
        }

        return dp[n][n];
    }
}
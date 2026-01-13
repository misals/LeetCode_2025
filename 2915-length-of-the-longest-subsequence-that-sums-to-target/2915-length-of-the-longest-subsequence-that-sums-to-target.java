class Solution {
    public int lengthOfLongestSubsequence(int ind, List<Integer> nums, int target, int[][] dp) {
        if (target == 0) {
            return 0;
        }
        if (ind < 0) {
            return -1000000;
        }

        if (dp[ind][target] != -1) return dp[ind][target];

        int notPick = lengthOfLongestSubsequence(ind - 1, nums, target, dp);
        int pick = -1000000;
        if (target >= nums.get(ind)) {
            pick = 1 + lengthOfLongestSubsequence(ind - 1, nums, target - nums.get(ind), dp);
        }

        return dp[ind][target] = Math.max(pick, notPick);
    }

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[][] dp = new int[n][target + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int val = lengthOfLongestSubsequence(n - 1, nums, target, dp);

        if (val <= 0) {
            return -1;
        }

        return val;
    }
}
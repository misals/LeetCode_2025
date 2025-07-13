class Solution {
    public int findTargetSumWays(int ind, int tar, int[] nums, int[][] dp) {
        if (ind == 0) {
            if (tar == 0 && nums[0] == 0) return 2;
            if (tar == 0 || nums[0] == tar) return 1;
            return 0;
        }

        if (dp[ind][tar] != -1) return dp[ind][tar];

        int notPick = findTargetSumWays(ind - 1, tar, nums, dp);
        int pick = 0;
        if (tar >= nums[ind]) {
            pick = findTargetSumWays(ind - 1, tar - nums[ind], nums, dp);
        }

        return dp[ind][tar] = pick + notPick;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        if (totalSum < Math.abs(target) || (totalSum + target) % 2 != 0) return 0;

        int tar = (totalSum + target) / 2;

        int[][] dp = new int[n][tar + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return findTargetSumWays(n - 1, tar, nums, dp);
    }
}

class Solution {
    public boolean canPartition(int ind, int n, int tar, int[] nums, int[][] dp) {
        if (tar == 0) {
            return true;
        }
        if (ind == n) {
            return false;
        }

        if (dp[ind][tar] != -1) {
            return dp[ind][tar] == 0 ? true : false;
        }

        if (canPartition(ind + 1, n, tar, nums, dp)) {
            dp[ind][tar] = 0;
            return true;
        }

        if (tar >= nums[ind]) {
            if (canPartition(ind + 1, n, tar - nums[ind], nums, dp)) {
                dp[ind][tar] = 0;
                return true;
            }
        }
        dp[ind][tar] = 1;
        return false;
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int tar = sum / 2;

        int[][] dp = new int[n + 1][tar + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return canPartition(0, n, tar, nums, dp);
    }
}
class Solution {
    public boolean canJump(int ind, int n, int[] nums, int[] dp) {
        if (ind >= n) {
            return true;
        }

        if (dp[ind] != -1) {
            return dp[ind] == 1;
        }

        for (int i = 1; i <= nums[ind]; i++) {
            if (canJump(ind + i, n, nums, dp)) {
                dp[ind] = 1;
                return true;
            }
        }
        dp[ind] = 0;
        return false;
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;

        if (nums[0] == 0) {
            return true;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return canJump(0, n, nums, dp);
    }
}
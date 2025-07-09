class Solution {
    public int houseRobber(int i, int nums[], int dp[]) {
        if (i == 0) {
            return nums[0];
        }
        if (dp[i] != -1) {
            return dp[i];
        }

        int notPick = houseRobber(i - 1, nums, dp);
        int pick = nums[i];
        if (i - 2 >= 0) {
            pick += houseRobber(i - 2, nums, dp);
        }
        return dp[i] = Math.max(pick, notPick);
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);

        houseRobber(n-1, nums, dp);

        return dp[n-1];
    }
}
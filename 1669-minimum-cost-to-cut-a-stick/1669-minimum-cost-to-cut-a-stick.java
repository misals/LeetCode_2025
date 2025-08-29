class Solution {
    public int minCost(int i, int j, int[] nums, int[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int mini = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int val = nums[j + 1] - nums[i - 1] + minCost(i, k - 1, nums, dp) + minCost(k + 1, j, nums, dp);
            mini = Math.min(mini, val);
        }
        return dp[i][j] = mini;
    }

    public int minCost(int n, int[] cuts) {
        int sz = cuts.length;

        int[] nums = new int[sz + 2];
        nums[0] = 0;
        nums[sz + 1] = n;

        for (int i = 0; i < sz; i++) {
            nums[i + 1] = cuts[i];
        }

        Arrays.sort(nums);

        int[][] dp = new int[sz + 2][sz + 2];

        for (int i = 0; i < sz + 2; i++) {
            Arrays.fill(dp[i], -1);
        }
        return minCost(1, sz, nums, dp);
    }
}
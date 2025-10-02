class Solution {
    public long splitArray(int[] nums) {
        int n = nums.length;

        long[] preSum = new long[n];
        long[] suffSum = new long[n];

        preSum[0] = nums[0];
        suffSum[n - 1] = nums[n - 1];

        boolean[] inc = new boolean[n];
        boolean[] dec = new boolean[n];

        inc[0] = true;
        dec[n - 1] = true;

        for (int i = 1; i < n; i++) {
            preSum[i] = nums[i] + preSum[i - 1];

            if (inc[i - 1] && nums[i] > nums[i - 1]) {
                inc[i] = true;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            suffSum[i] = nums[i] + suffSum[i + 1];

            if (dec[i + 1] && nums[i] > nums[i + 1]) {
                dec[i] = true;
            }
        }

        long ans = Long.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            if (inc[i] && dec[i + 1]) {
                ans = Math.min(ans, Math.abs(preSum[i] - suffSum[i + 1]));
            }
        }

        return ans == Long.MAX_VALUE ? -1 : ans;

    }
}
class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (i >= k - 1) {
                int val = nums[i] - nums[i - k + 1];
                ans = Math.min(ans, val);
            }
        }
        return n == 1 ? 0 : ans;
    }
}
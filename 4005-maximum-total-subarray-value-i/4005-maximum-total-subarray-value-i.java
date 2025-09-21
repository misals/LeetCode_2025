class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        long maxi = Integer.MIN_VALUE;
        long mini =  Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
            mini = Math.min(mini, nums[i]);
        }
        return (long)k * (maxi - mini);
    }
}
class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            maxi = Math.max(maxi, nums[i] - nums[i-1]);
        }

        maxi = Math.max(maxi, nums[n-1] - nums[0]);

        return Math.abs(maxi);
    }
}
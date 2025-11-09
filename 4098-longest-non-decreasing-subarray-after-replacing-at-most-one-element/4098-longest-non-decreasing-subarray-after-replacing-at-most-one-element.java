class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxi = 0;

        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < n; i++) {
            if (nums[i] >= nums[i - 1]) {
                left[i] = 1 + left[i - 1];
            }
            maxi = Math.max(maxi, left[i]);
        }

        maxi = Math.min(n, maxi + 1);

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i + 1] >= nums[i]) {
                right[i] = 1 + right[i + 1];
            }
        }

        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] <= nums[i + 1]) {
                maxi = Math.max(maxi, left[i - 1] + right[i + 1] + 1);
            }
        }

        return maxi;
    }
}
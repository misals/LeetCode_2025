class Solution {
    public int minimumPrefixLength(int[] nums) {
        int n = nums.length;

        for (int i = n - 1; i >= 1; i--) {
            if (nums[i] <= nums[i - 1]) {
                return i;
            }
        }
        return 0;
    }
}
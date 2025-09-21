class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                ans |= nums[i];
            }
        }
        return ans;
    }
}
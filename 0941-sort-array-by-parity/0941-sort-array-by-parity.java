class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int ind = 0;

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                ans[ind] = nums[i];
                ind++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 != 0) {
                ans[ind] = nums[i];
                ind++;
            }
        }
        return ans;
    }
}
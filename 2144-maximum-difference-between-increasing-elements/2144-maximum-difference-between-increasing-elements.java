class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int minNum = nums[0];
        int ans = -1;

        for (int i = 1; i < n; i++) {
            if (minNum != nums[i]) {
                ans = Math.max(ans, nums[i] - minNum);
            }
            minNum = Math.min(minNum, nums[i]);
        }
        return ans;
    }
}
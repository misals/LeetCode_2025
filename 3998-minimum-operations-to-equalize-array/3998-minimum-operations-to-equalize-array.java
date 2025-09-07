class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int cnt = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                cnt++;
            }
        }

        return cnt >= 1 ? 1 : 0;
    }
}
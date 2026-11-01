class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;

        int minVal = Integer.MAX_VALUE;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < minVal) {
                minVal = nums[i];
            }
        }

        for (int i = 0; i < n; i++) {
            cnt += nums[i] - minVal;
        }

        return cnt;
    }
}
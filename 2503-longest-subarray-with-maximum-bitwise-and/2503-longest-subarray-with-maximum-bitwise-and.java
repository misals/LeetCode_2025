class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxi = 0;
        int cnt = 1;
        int maxCnt = 1;

        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == maxi) {
                if (i - 1 >= 0 && nums[i-1] == maxi) {
                    cnt++;
                    maxCnt = Math.max(maxCnt, cnt);
                } else {
                    cnt = 1;
                }
            }
        }
        return maxCnt;
    }
}
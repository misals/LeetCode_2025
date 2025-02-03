class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;

        int cnt1 = 1;
        int cnt2 = 1;

        int ans = 1;

        for (int i = 1; i < n; i++) {
            
            if (nums[i] > nums[i-1]) {
                cnt1++;
                ans = Math.max(ans, cnt1);
            } else {
                cnt1 = 1;
            }
            
            if (nums[i] < nums[i-1]) {
                cnt2++;
                ans = Math.max(ans, cnt2);
            } else {
                cnt2 = 1;
            }
        }
        return ans;
    }
}
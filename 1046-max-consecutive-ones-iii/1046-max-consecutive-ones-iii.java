class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;

        int ans = 0;
        int cnt = 0;

        int left = 0;
        int right = 0;

        while (right < n) {
            if (nums[right] == 0) {
                cnt++;
            }

            while (cnt > k) {
                if (nums[left] == 0) {
                    cnt--;
                }
                left++;
            }

            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
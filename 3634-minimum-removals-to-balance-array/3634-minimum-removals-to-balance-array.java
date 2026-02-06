class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int i = 0;
        int maxLen = 0;

        for (int j = 0; j < n; j++) {
            while (i < n && ((long) nums[j] > (long) nums[i] * k)) {
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }

        return n - maxLen;    
    }
}
class Solution {
    public int dominantIndices(int[] nums) {
        int n = nums.length;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int cnt = 0;

        for (int i = 0; i < n - 1; i++) {
            int num = sum - nums[i];

            if (nums[i] > (num / (n - i - 1))) {
                cnt++;
            }

            sum -= nums[i];
        }

        return cnt;
    }
}
class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int currSum = 0;
        for (int i = 0; i < n - 1; i++) {
            currSum += nums[i];

            int diff = Math.abs(currSum - (sum - currSum));
            if (diff % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
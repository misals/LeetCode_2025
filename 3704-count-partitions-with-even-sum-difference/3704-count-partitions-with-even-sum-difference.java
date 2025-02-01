class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;

        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];
            int rightSum = sum - leftSum;

            if (Math.abs(leftSum - rightSum) % 2 == 0) {
                cnt++;
            }
        }
        return cnt;

    }
}
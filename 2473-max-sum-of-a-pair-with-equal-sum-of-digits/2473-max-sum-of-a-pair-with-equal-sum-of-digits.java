class Solution {
    public int getDigitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public int maximumSum(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> maxSum = new HashMap<>();

        int ans = -1;

        for (int i = 0; i < n; i++) {
            int digitSum = getDigitSum(nums[i]);

            if (maxSum.containsKey(digitSum)) {
                ans = Math.max(ans, nums[i] + maxSum.get(digitSum));
                if (nums[i] > maxSum.get(digitSum)) {
                    maxSum.put(digitSum, nums[i]);
                }
            } else {
                maxSum.put(digitSum, nums[i]);
            }
        }
        return ans;
    }
}
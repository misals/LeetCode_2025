class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int prev = nums[0];
        int secondPrev = 0;

        for (int i = 1; i < n; i++) {
            int notPick = prev;
            int pick = nums[i];

            if (i - 2 >= 0) {
                pick += secondPrev;
            }

            int curr = Math.max(pick, notPick);
            secondPrev = prev;
            prev = curr;
        }

        return prev;
    }
}
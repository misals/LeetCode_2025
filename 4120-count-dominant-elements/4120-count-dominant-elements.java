class Solution {
    public int countDominantElements(int[] nums) {
        int n = nums.length;

        if (n == 1) return 1;

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (nums[i] >= nums[i + 1]) {
                    cnt++;
                }
            } else if (i == n - 1) {
                if (nums[i] >= nums[i - 1]) {
                    cnt++;
                }
            } else {
                if (nums[i] >= ((nums[i - 1] + nums[i + 1]) / 2.0)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
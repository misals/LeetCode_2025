class Solution {
    public int countConsistent(int[] nums) {
        int n = nums.length;

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int minVal = nums[i];
            int val = nums[i];

            for (int j = i; j < n; j++) {
                if (nums[j] <= minVal) {
                    minVal = nums[j];
                }

                val &= nums[j];

                if (val == minVal) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int tempCnt = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == target) {
                    tempCnt++;
                }

                if (tempCnt > (j - i + 1) / 2) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
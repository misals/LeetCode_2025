class Solution {
    public int getIncreasing(int ind, List<Integer> nums, int k, int n) {
        if (ind >= n) {
            return 0;
        }

        int cnt = 1;
        for (int i = ind + 1; i < Math.min(n, ind + k); i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            int cnt1 = getIncreasing(i, nums, k, n);
            int cnt2 = getIncreasing(i + k, nums, k, n);

            if (cnt1 + cnt2 == k * 2) {
                return true;
            }
        }
        return false;
    }
}
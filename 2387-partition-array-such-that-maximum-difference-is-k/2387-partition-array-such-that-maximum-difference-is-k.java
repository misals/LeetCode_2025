class Solution {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int ans = 1;
        int val = nums[n-1];

        for (int i = n - 1; i >= 0; i--) {
            if (val - nums[i] > k) {
                val = nums[i];
                ans++;
            }
        }

        return ans;
    }
}
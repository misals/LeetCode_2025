class Solution {
    public int countElements(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        int i = 0;

        while (i < n) {
            int curr = nums[i];
            int j = i;

            while (j < n && nums[j] == curr) {
                j++;
            }

            if (n - j >= k) {
                ans += (j - i);
            }
            i = j;
        }
        return ans;
    }
}
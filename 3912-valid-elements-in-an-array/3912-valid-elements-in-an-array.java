class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;

        boolean[] pre = new boolean[n];
        pre[0] = true;

        boolean[] suf = new boolean[n];
        suf[n - 1] = true;

        int maxi = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] > maxi) {
                pre[i] = true;
                maxi = nums[i];
            }
        }

        maxi = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > maxi) {
                suf[i] = true;
                maxi = nums[i];
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (pre[i] || suf[i]) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }
}
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        boolean [] vis = new boolean[n];

        int[] ans = new int[2];
        int ind = 0;

        for (int i = 0; i < n; i++) {
            if (vis[nums[i]]) {
                ans[ind] = nums[i];
                ind++;
            } 
            vis[nums[i]] = true;
        }
        return ans;
    }
}
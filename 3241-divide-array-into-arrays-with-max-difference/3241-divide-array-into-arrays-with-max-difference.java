class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ind = 0;

        int[][] ans = new int[n / 3][3];

        for (int i = 0; i < n - 2; i+= 3) {
            if (nums[i + 2] - nums[i] <= k) {
                int[] temp = new int[3];
                temp[0] = nums[i];
                temp[1] = nums[i+1];
                temp[2] = nums[i+2];

                ans[ind] = temp;
                ind++;
            } else {
                return new int[0][0];
            }
        }

        return ans;
    }
}
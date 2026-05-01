class Solution {
    public int maxRotateFunction(int[] nums) {
       int n = nums.length;
       int sum = 0;
       int prevF = 0;
       for (int i = 0; i < n; ++i ) {
        sum += nums[i];
        prevF += (i * nums[i]);
       } 
       int ans = prevF;
       for (int i = n-1; i >= 1; --i ) {
        prevF += sum - (nums[i] * n);
        ans = Math.max(ans,prevF);
       }
       return ans;
    }
}
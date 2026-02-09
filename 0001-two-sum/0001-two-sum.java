class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int low = 0;
        int high = n - 1;

        while (low < high) {
            int val = arr[low][0] + arr[high][0];

            if (val == target) {
                ans[0] = arr[low][1];
                ans[1] = arr[high][1];

                return ans;
            } else if (val < target) {
                low++;
            } else {
                high--;
            }
        }
        
        return ans;
    }
}
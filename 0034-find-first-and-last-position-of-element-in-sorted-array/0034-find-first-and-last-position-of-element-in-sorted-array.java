class Solution {
    public int findFirst(int low, int high, int[] nums, int target) {
        int ind = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ind = mid;
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ind;
    }

    public int findSecond(int low, int high, int[] nums, int target) {
        int ind = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                ind = mid;
                low = mid + 1; 
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ind;
    } 

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];

        ans[0] = findFirst(0, n - 1, nums, target);
        ans[1] = findSecond(0, n - 1, nums, target);

        return ans;
    }
}
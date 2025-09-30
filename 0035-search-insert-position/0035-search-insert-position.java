class Solution {
    public int searchInsert(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                ans = mid + 1;
                low = mid + 1;
            } else {
                ans = Math.max(0, mid);
                high = mid - 1;
            }
        }
        return ans;
    }
}
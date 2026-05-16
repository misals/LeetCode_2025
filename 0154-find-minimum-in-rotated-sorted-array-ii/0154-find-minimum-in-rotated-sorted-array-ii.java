class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                // Minimum lies in the right half
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                // Minimum is at mid or in the left half
                high = mid;
            } else {
                // Cannot determine the correct half because of duplicates
                high--;
            }
        }

        return nums[low];
    }
}
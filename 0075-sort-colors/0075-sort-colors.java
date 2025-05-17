class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        int i = 0;
        int low = 0;
        int high = n - 1;

        while (i <= high) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                int temp = nums[low];
                nums[low] = nums[i];
                nums[i] = temp;
                low++;
                i++;
            } else {
                int temp = nums[high];
                nums[high] = nums[i];
                nums[i] = temp;
                high--;
            }
        }
    }
}
class Solution {
    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;

        int ans = 0;

        while (low <= high) {
            int distance = high - low;
            int num = Math.min(height[low], height[high]);

            ans = Math.max(ans, distance * num);

            if (height[low] <= height[high]) {
                low++;
            } else {
                high--;
            }
        }

        return ans;
    }
}
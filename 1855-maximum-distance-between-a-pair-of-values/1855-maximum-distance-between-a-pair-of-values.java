class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int i = 0;
        int j = 0;

        int maxi = 0;

        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                if (j >= i) {
                    maxi = Math.max(maxi, j - i);
                }
                j++;
            } else {
                i++;
            }
        }
        return maxi;
    }
}
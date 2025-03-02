class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        Map<Integer, Integer> mp = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            mp.put(nums1[i][0], nums1[i][1]);
        }

        for (int i = 0; i < m; i++) {
            if (mp.containsKey(nums2[i][0])) {
                mp.put(nums2[i][0], mp.get(nums2[i][0]) + nums2[i][1]);
            } else {
                mp.put(nums2[i][0], nums2[i][1]);
            }
        }

        int [][] array = new int[mp.size()][2];
        int count = 0;
        
        for(Map.Entry<Integer,Integer> entry : mp.entrySet()) {
            array[count][0] = entry.getKey();
            array[count][1] = entry.getValue();
            count++;
        }

        return array;
    }
}
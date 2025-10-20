class Solution {
    public int missingMultiple(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : nums) {
            mp.put(num, 1);
        }

        int i = 1;

        while (i >= 1) {
            if (mp.get(k * i) == null) {
                return k * i;
            }
            i++;
        }
        return k;
    }
}
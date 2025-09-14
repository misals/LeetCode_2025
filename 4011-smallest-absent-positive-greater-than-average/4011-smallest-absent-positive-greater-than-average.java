class Solution {
    public int smallestAbsent(int[] nums) {
        int n = nums.length;
        int avg = 0;

        Map<Integer, Integer> mp = new HashMap<>();

        for (int it : nums) {
            avg += it;
            mp.put(it, 1);
        }
        avg /= n;
        avg++;

        while (true) {
            if (avg > 0 && mp.get(avg) == null) {
                return avg;
            }
            avg++;
        }

    }
}
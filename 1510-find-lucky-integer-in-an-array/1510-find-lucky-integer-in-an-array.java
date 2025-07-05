class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i : arr) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }

        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getKey() == entry.getValue()) {
                ans = Math.max(ans, entry.getKey());
            }
        }

        return ans;
    }
}
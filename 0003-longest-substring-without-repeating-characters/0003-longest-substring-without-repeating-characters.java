class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        Map<Character, Integer> mp = new HashMap<>();
        int maxi = 0;
        int low = 0;

        for (int i = 0; i < n; i++) {
            if (mp.containsKey(s.charAt(i))) {
                low = Math.max(low, mp.get(s.charAt(i)) + 1);
            }

            mp.put(s.charAt(i), i);

            maxi = Math.max(maxi, i - low + 1);
        }

        return maxi;
    }
}
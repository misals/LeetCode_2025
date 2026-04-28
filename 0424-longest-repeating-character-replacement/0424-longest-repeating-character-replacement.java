class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int lo = 0;
        int hi = 0;

        int maxFreq = 0;
        int ans = 0;

        int[] hash = new int[26];

        while (hi < n) {
            hash[s.charAt(hi) - 'A']++;

            maxFreq = Math.max(maxFreq, hash[s.charAt(hi) - 'A']);

            while (lo < n && (hi - lo + 1) - maxFreq > k) {
                hash[s.charAt(lo) - 'A']--;

                for (int i = 0; i < 26; i++) {
                    maxFreq = Math.max(maxFreq, hash[i]);
                }
                lo++;
            }

            if ((hi - lo + 1) - maxFreq <= k) {
                ans = Math.max(ans, hi - lo + 1);
            }
            hi++;
        }
        return ans;
    }
}
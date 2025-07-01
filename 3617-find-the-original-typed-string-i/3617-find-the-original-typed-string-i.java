class Solution {
    public int possibleStringCount(String word) {
        
        int ans = 1;
        int n = word.length();

        int lo = 0;

        while (lo < n) {
            int cnt = 1;
            int hi = lo + 1;

            while (hi < n && word.charAt(lo) == word.charAt(hi)) {
                hi++;
                cnt++;
            }
            lo = hi;
            ans += cnt - 1;
        }

        return ans;
    }
}
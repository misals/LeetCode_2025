class Solution {
    public int maxDifference(String s) {
        int n = s.length();

        char[] ch = new char[26];
        int oddMax = Integer.MIN_VALUE;
        int evenMin = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            ch[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (ch[i] > 0) {
                if (ch[i] % 2 == 0) {
                    evenMin = Math.min(evenMin, ch[i]);
                } else {
                    oddMax = Math.max(oddMax, ch[i]);
                }
            }
        }

        return oddMax - evenMin;
    }
}
class Solution {
    public String majorityFrequencyGroup(String s) {
        int n = s.length();
        int[] arr = new int[26];

        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
        }

        int maxCnt = 0;
        int freq = 0;

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 0; j < 26; j++) {
                if (arr[j] == i) {
                    cnt++;
                }
            }
            if (cnt >= maxCnt) {
                maxCnt = cnt;
                freq = i;
            } 
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (arr[i] == freq) {
                sb.append((char)('a' + i));
            }
        }
        return sb.toString();
    }
}
class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];

        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);

        int result = Integer.MAX_VALUE;
        int deletedTillNow = 0;
        
        for (int i = 0; i < 26; i++) {
            int minFreq = freq[i];
            int temp = deletedTillNow;

            for (int j = i + 1; j < 26; j++) {
                if (freq[j] - freq[i] > k) {
                    temp += freq[j] - minFreq - k;
                }
            }

            result = Math.min(result, temp);
            deletedTillNow += minFreq;
        }
        return result;
    }
}
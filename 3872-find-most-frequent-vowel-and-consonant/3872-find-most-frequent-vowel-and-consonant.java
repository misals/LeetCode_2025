class Solution {
    public boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'o' || ch == 'i' || ch == 'u') {
            return true;
        }
        return false;
    }

    public int maxFreqSum(String s) {
        int n = s.length();
        int[] arr = new int[26];

        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
        }

        int vowel = 0;
        int consonant = 0;

        for (int i = 0; i < n; i++) {
            if (isVowel(s.charAt(i))) {
                vowel = Math.max(vowel, arr[s.charAt(i) - 'a']);
            } else {
                consonant = Math.max(consonant, arr[s.charAt(i) - 'a']);
            }
        }
        return vowel + consonant;
    }
}
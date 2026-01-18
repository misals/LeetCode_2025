class Solution {
    public boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }

    public int vowelConsonantScore(String s) {
        int n = s.length();
        boolean vowel = false;
        boolean consonent = false;

        int cnt1 = 0;
        int cnt2 = 0;

        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                vowel = true;
                cnt1++;
            } else if (ch >= 'a' && ch <= 'z') {
                consonent = true;
                cnt2++;
            }
        }

        return vowel && consonent ? cnt1 / cnt2 : 0;

    }
}
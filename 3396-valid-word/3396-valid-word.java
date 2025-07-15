class Solution {
    public boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;
        }
        return false;
    }


    public boolean isValid(String word) {
        boolean vowel = false;
        boolean consonant = false;

        int n = word.length();

        if (n < 3) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);

            if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
                if (isVowel(ch)) {
                    vowel = true;
                } else {
                    consonant = true;
                }
            } else if (ch >= '0' && ch <= '9') {

            } else {
                return false;
            }
        }

        return vowel && consonant;
    }
}
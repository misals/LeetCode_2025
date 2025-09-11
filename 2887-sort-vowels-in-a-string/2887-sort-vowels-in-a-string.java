class Solution {
    public boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;
        }
        return false;
    }

    public String sortVowels(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (isVowel(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }

        char[] charArray = sb.toString().toCharArray();

        Arrays.sort(charArray);

        StringBuilder ans = new StringBuilder();
        int ind = 0;

        for (int i = 0; i < n; i++) {
            if (isVowel(s.charAt(i))) {
                ans.append(charArray[ind]);
                ind++;
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}
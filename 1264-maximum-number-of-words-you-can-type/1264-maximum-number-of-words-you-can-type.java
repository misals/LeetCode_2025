class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] str = text.split(" ");

        int n = str.length;

        int cnt = 0;
        for (String str1 : str) {
            for (char ch : brokenLetters.toCharArray()) {
                char[] ch1 = str1.toCharArray();

                int m = ch1.length;
                boolean flag = false;

                for (int j = 0; j < m; j++) {
                    if (ch == ch1[j]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    cnt++;
                    break;
                }
            }
        }
        return n - cnt;
    }
}
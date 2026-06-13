class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length;

        StringBuilder sb = new StringBuilder();

        for (String s : words) {
            int sz = s.length();
            int sum = 0;

            for (int i = 0; i < sz; i++) {
                sum += weights[s.charAt(i) - 'a'];
            }

            int num = sum % 26;

            int val = 26 - num;

            char ch = (char) ('a' + val - 1);
            sb.append(ch);
        }

        return sb.toString();
    }
}
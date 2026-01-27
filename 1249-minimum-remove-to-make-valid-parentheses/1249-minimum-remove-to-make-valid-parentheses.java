class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();
        boolean[] valid = new boolean[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else if (s.charAt(i) == ')') {
                if (!st.isEmpty()) {
                    valid[st.pop()] = true;
                    valid[i] = true;
                } 
            } else {
                valid[i] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (valid[i] == true || (s.charAt(i) != ')' && s.charAt(i) != '(')) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
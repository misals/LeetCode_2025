class Solution {
    public String rotate(String s) {
        char[] ch = s.toCharArray();
        int n = s.length();

        char c = ch[0];

        for (int i = 1; i < n; i++) {
            ch[i - 1] = ch[i];
        }
        ch[n - 1] = c;

        return new String(ch);
        
    }

    public boolean rotateString(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (n != m) return false;

        while (n-- >= 0) {
            if (s.equals(t)) {
                return true;
            }
            s = rotate(s);
        }
        return false;

    }
}

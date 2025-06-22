class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();

        int size;
        if (n % k == 0) {
            size = n / k;
        } else {
            size = n / k + 1;
        }

        String[] ans = new String[size];
        int ind = 0;

        for (int i = 0; i < n; i += k) {

            String temp = "";
            int cnt = 0;
            for (int j = i; j < n && j < i + k; j++) {
                temp += s.charAt(j);
                cnt++;
            }

            if (ind == size - 1 && n % k != 0) {
                for (int j = 0; j < k - cnt; j++) {
                    temp += fill;
                }
            }
            ans[ind] = temp;
            ind++;
        }

        return ans; 
    }
}
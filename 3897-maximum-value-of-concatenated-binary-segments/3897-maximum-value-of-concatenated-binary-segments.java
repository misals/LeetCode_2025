class Solution {
    static int MOD = (int)1e9 + 7;

    public int maxValue(int[] nums1, int[] nums0) {
        int n = nums1.length;

        ArrayList<String> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < nums1[i]; j++) {
                sb.append(1);
            }
            for (int j = 0; j < nums0[i]; j++) {
                sb.append(0);
            }
            res.add(sb.toString());
        }

        Collections.sort(res, (a, b) -> (b + a).compareTo(a + b));

        long ans = 0;

        for (String s : res) {
            for (char ch : s.toCharArray()) {
                ans = (ans * 2 + (ch - '0')) % MOD;
            }
        }

        return (int)ans;
    }
}
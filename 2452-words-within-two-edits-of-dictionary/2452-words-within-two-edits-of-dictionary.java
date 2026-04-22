class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int n = queries.length;
        int m = dictionary.length;

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sz = queries[i].length();
                int cnt = 0;

                for (int k = 0; k < sz; k++) {
                    if (queries[i].charAt(k) != dictionary[j].charAt(k)) {
                        cnt++;
                    }
                }

                if (cnt <= 2) {
                    ans.add(queries[i]);
                    break;
                }
            }
        }

        return ans;
    }
}
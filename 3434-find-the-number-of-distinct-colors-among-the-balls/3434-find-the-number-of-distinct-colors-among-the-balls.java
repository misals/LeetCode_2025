class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        int distinct = 0;
        Map<Integer, Integer> ball = new HashMap<>();
        Map<Integer, Integer> color = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int pos = queries[i][0];
            int c = queries[i][1];

            if (ball.containsKey(pos)) {
                int cnt = color.get(ball.get(pos)) - 1;
                if (cnt == 0) {
                    color.remove(ball.get(pos));
                    distinct--;
                } else {
                    color.put(ball.get(pos), cnt);
                }
            }
            ball.put(pos, c);
            int cnt = color.getOrDefault(c, 0) + 1;
            color.put(c, cnt);
            if (cnt == 1) {
                distinct++;
            }
            res[i] = distinct;
        }
        return res;
    }
}
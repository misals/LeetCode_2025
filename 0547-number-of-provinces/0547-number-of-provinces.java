class Solution {
    public void dfs(int node, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;

        for (int num : adj.get(node)) {
            if (!vis[num]) {
                dfs(num, adj, vis);
            }
        }
    }

    public int findCircleNum(int[][] arr) {
        int n = arr.length;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[n];

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                cnt++;
                dfs(i, adj, vis);
            }
        }
        return cnt;
    }
}
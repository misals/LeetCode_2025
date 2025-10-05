class Solution {
    public boolean dfs(int node, int c, int[] color, List<List<Integer>> adj) {
        color[node] = c;

        for (int num : adj.get(node)) {
            if (color[num] == -1) {
                color[num] = 1 - color[node];
                if (!dfs(num, 1 - color[node], color, adj)) {
                    return false;
                }
            } else if (color[node] == color[num]) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, adj)) {
                    return false;
                }
            }
        }
        return true;
    }
}
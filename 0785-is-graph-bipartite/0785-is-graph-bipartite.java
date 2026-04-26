class Solution {
    public boolean checkBipartite(int node, int col, int[] color, List<List<Integer>> adj) {

        color[node] = col;

        for (int it : adj.get(node)) {
            if (color[it] == -1) {
                color[it] = 1 - color[node];
                if (!checkBipartite(it, 1 - color[node], color, adj)) {
                    return false;
                }
            } else if (color[it] == color[node]) {
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
                if (!checkBipartite(i, 0, color, adj)) {
                    return false;
                }
            }
        }
        return true;
    }
}
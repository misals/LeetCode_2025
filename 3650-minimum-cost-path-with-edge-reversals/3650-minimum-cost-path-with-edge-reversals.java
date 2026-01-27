class Solution {
    public int minCost(int n, int[][] edges) {
        List<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            int w = e[2];

            adj[x].add(new int[] {y, w});
            adj[y].add(new int[] {x, 2 * w});
        }

        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;

        boolean[] vis = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );

        pq.offer(new int[] {0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int dist = curr[0];
            int node = curr[1];

            if (node == n - 1) {
                return dist;
            }

            if (vis[node]) {
                continue;
            }

            vis[node] = true;

            for (int[] neighbor : adj[node]) {
                int y = neighbor[0];
                int w = neighbor[1];

                if (dist + w < ans[y]) {
                    ans[y] = dist + w;

                    pq.offer(new int[] {ans[y], y});
                }
            }
        }
        return -1;
    }
}
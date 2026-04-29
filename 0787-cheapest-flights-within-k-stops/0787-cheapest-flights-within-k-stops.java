class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] it : flights) {
            adj.get(it[0]).add(new int[] {it[1], it[2]});
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {src, 0});

        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        int stops = 0;

        while (!q.isEmpty() && stops <= k) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();

                int prevNode = curr[0];
                int prevDist = curr[1];

                for (int[] it : adj.get(prevNode)) {
                    int currNode = it[0];
                    int currDist = it[1];

                    if (prevDist + currDist < minDist[currNode]) {
                        minDist[currNode] = prevDist + currDist;
                        q.offer(new int[] {currNode, minDist[currNode]});
                    }
                }
            }

            stops++;
        }

        return minDist[dst] == Integer.MAX_VALUE ? -1 : minDist[dst];
    }
}
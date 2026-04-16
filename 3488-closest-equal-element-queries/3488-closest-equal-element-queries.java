class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;

        Map<Integer, List<Integer>> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int ele = nums[queries[i]];

            List<Integer> numList = mp.get(ele);

            int size = numList.size();

            if (size == 1) {
                result.add(-1);
                continue;
            }

            int position = Collections.binarySearch(numList, queries[i]);
            int res = Integer.MAX_VALUE;

            int rightDistance = numList.get((position + 1) % size);
            int dist = Math.abs(queries[i] - rightDistance);
            int circularDist = n - dist;
            res = Math.min(res, Math.min(dist, circularDist));

            int leftDistance = numList.get((position - 1 + size) % size);
            dist = Math.abs(queries[i] - leftDistance);
            circularDist = n - dist;
            res = Math.min(res, Math.min(dist, circularDist));

            result.add(res);
            
        }
        return result;
    }
}
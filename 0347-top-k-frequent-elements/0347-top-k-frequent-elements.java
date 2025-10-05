class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        for (int num : mp.keySet()) {
            int[] arr = {num, mp.get(num)};

            if (pq.size() < k) {
                pq.add(arr);
            } else if (arr[1] > pq.peek()[1]) {
                pq.remove();
                pq.add(arr);
            }
        }

        int[] ans = new int[k];
        int ind = 0;

        while (!pq.isEmpty()) {
            ans[ind] = pq.remove()[0];
            ind++;
        }

        return ans;
    }
}
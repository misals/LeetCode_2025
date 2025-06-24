class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list = new ArrayList<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                list.add(i);
            }
        }

        int sz = list.size();
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < sz; i++) {
            int ind = list.get(i);
            for (int j = 0; j < n; j++) {
                if (Math.abs(ind - j) <= k) {
                    set.add(j);
                }
            }
        }

        List<Integer> ans = new ArrayList<>(set);

        return ans;
    }
}
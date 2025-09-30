class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] == x) {
                list.add(i);
            }
        }

        int sz = list.size();
        int ind = 0;
        int m = queries.length;

        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            int val = queries[i];

            if (val > sz) {
                ans[i] = -1;
            } else {
                ans[i] = list.get(val - 1);
                ind++;
            }
        }
        return ans;
    }
}
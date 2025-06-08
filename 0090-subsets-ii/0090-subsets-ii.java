class Solution {
    public void findSubset(int ind, int n, int[] nums, List<Integer> temp, Set<List<Integer>> ans) {
        if (ind == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = ind; i < n; i++) {
            if (i > ind && nums[i] == nums[i-1]) continue;

            temp.add(nums[i]);
            findSubset(i+1, n, nums, temp, ans);
            temp.remove(temp.size() - 1);
        }
        findSubset(ind+1, n, nums, temp, ans);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();

        findSubset(0, n, nums, new ArrayList<>(), ans);
        List<List<Integer>> res = new ArrayList<>(ans);

        return res;
    }
}
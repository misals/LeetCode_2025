class Solution {
    public void subsetsWithDup(int ind, int n, int[] nums, List<Integer> temp, List<List<Integer>> ans) {
      
        ans.add(new ArrayList<>(temp));

        for (int i = ind; i < n; i++) {
            if (i > ind && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            subsetsWithDup(i + 1, n, nums, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        subsetsWithDup(0, n, nums, temp, ans);

        return ans;

    }
}
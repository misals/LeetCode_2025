class Solution {
    public void combinationSum(int ind, int n, int target, int[] candidates, List<Integer> temp, Set<List<Integer>> ans) {
        if (ind == n) {
            if (target == 0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        combinationSum(ind + 1, n, target, candidates, temp, ans);

        if (target >= candidates[ind]) {
            temp.add(candidates[ind]);
            combinationSum(ind, n, target - candidates[ind], candidates, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;

        Set<List<Integer>> ans = new HashSet<>();

        List<Integer> temp = new ArrayList<>();

        combinationSum(0, n, target, candidates, temp, ans);

        List<List<Integer>> res = new ArrayList<>(ans);

        return res;
    }
}
class Solution {
    public void findDistinct(int i, int n, int val, int[] candidate, int sum, Set<List<Integer>> ans, List<Integer> temp) {
        if (val > sum) {
            return;
        }
        if (val == sum) {
                ans.add(new ArrayList<>(temp));
                return;
            }
        if (i == n) {
            if (val == sum) {
                ans.add(temp);
            }
            return;
        }
        val += candidate[i];
        temp.add(candidate[i]);
        findDistinct(i, n, val, candidate, sum, ans, temp);
        val -= candidate[i];
        temp.remove(temp.size() - 1);
        findDistinct(i + 1, n, val, candidate, sum, ans, temp);
    }

    public List<List<Integer>> combinationSum(int[] candidate, int target) {
        int n = candidate.length;

        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> temp = new ArrayList<>();

        findDistinct(0, n, 0, candidate, target, ans, temp);

        List<List<Integer>> res = new ArrayList<>(ans);

        return res;
    }
}
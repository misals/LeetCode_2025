class Solution {
    public boolean checkPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public void partition(int ind, int n, String s, List<String> path, List<List<String>> ans) {
        if (ind == n) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = ind ; i < n; i++) {
            if (checkPalindrome(s, ind, i)) {
                path.add(s.substring(ind, i + 1));
                partition(i + 1, n, s, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        int n = s.length();

        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        partition(0, n, s, path, ans);

        return ans;
    }
}
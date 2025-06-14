class Solution {
    public boolean isPalindrome(String s, int start, int end) {
        while(start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public void doPartition(int ind, String s, List<String> path, List<List<String>> ans) {
        if (ind == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = ind; i < s.length(); i++) {
            if (isPalindrome(s, ind, i)) {
                path.add(s.substring(ind, i + 1));
                doPartition(i + 1, s, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        doPartition(0, s, path, ans);

        return ans;
    }
}
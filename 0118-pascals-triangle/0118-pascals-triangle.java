class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    temp.add(1);
                } else {
                    List<Integer> tempList = ans.get(i - 2);
                    int val = tempList.get(j - 1) + tempList.get(j - 2);
                    temp.add(val);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}
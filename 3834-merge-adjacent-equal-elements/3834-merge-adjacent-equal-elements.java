class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        int n = nums.length;

        Stack<Long> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            long curr = nums[i];

            while (!st.isEmpty() && curr == st.peek()) {
                curr += st.pop();
            }
            
            st.push((long) curr);
        }
                

        List<Long> ans = new ArrayList<>();

        while (!st.isEmpty()) {
            ans.add(st.pop());
        }

        Collections.reverse(ans);

        return ans;
    }
}
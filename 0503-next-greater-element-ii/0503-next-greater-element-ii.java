class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            st.push(nums[i]);
        }

        int[] nextGreater = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = st.peek();
            }
            st.push(nums[i]);
        }

        return nextGreater;
    }
}
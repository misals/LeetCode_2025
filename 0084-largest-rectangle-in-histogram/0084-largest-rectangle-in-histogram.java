class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                left[i] = 0;
            } else {
                left[i] = st.peek() + 1;
            }
            st.push(i);
        }

        Stack<Integer> st1 = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st1.isEmpty() && heights[st1.peek()] >= heights[i]) {
                st1.pop();
            } 

            if (st1.isEmpty()) {
                right[i] = n - 1;
            } else {
                right[i] = st1.peek() - 1;
            }
            st1.push(i);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] + 1) * heights[i]);
        }
        return ans;
    }
}
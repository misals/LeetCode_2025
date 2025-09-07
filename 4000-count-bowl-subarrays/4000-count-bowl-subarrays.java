class Solution {
    public long bowlSubarrays(int[] nums) {
        int n = nums.length;

        Stack<Integer> st = new Stack<>();

        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = 1;
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            st.pop();
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                right[i] = -1;
            } else {
                right[i] = 1;
            }
            st.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] == 1 && right[i] == 1) {
                ans++;
            }
        }
        return ans;
    }
}
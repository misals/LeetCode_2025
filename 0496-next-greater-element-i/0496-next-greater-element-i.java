class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] nge = new int[m];

        Stack<Integer> st = new Stack<Integer>();

        for (int i = m - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums2[st.peek()] <= nums2[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = nums2[st.peek()];
            }
            st.push(i);
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums1[i] == nums2[j]) {
                    ans[i] = nge[j];
                    break;
                }
            }
        }
        return ans;
    }
}
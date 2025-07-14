/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        String s = "";

        while (head != null) {
            int val = head.val;
            s = s + val;
            head = head.next;
        }

        int n = s.length();
        int ans = 0;
        int base = 1;

        for (int i = n - 1; i >= 0; i--) {
            int val = s.charAt(i) - '0';
            ans += val * base;
            base *= 2;
        }

        return ans;
    }
}
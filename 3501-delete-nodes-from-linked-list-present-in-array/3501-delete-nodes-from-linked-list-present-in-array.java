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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode currNode = head;
        ListNode prevNode = null;
        ListNode ans = null;

        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.put(num, 1);
        }

        while (currNode != null) {
            int currVal = currNode.val;

            if (mp.containsKey(currVal)) {
                if (prevNode != null) {
                    prevNode.next = currNode.next;
                }
            } else {
                if (ans == null) {
                    ans = currNode;
                }
                prevNode = currNode;
            }
            currNode = currNode.next;
        }

        return ans;
    }
}
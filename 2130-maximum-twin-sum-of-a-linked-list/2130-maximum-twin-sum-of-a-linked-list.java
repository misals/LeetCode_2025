class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        int maxSum = 0;

        while (slow != null) {
            int sum = prev.val + slow.val;

            if (sum > maxSum) {
                maxSum = sum;
            }

            prev = prev.next;
            slow = slow.next;
        }

        return maxSum;
    }
}

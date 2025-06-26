/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Tuple {
    TreeNode node;
    int ind;
    public Tuple(TreeNode _node, int _ind) {
        node = _node;
        ind = _ind;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0));

        int ans = 0;

        while (!q.isEmpty()) {
            int n = q.size();
            int min = q.peek().ind;

            int first = 0;
            int last = 0;

            for (int i = 0; i < n; i++) {
                Tuple tuple = q.poll();
                TreeNode node = tuple.node;
                int num = tuple.ind - min;

                if (i == 0) {
                    first = num;
                }
                if (i == n - 1) {
                    last = num;
                }

                if (node.left != null) {
                    q.offer(new Tuple(node.left, num * 2 + 1));
                }
                if (node.right != null) {
                    q.offer(new Tuple(node.right, num * 2 + 2));
                }
            }

            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }
}
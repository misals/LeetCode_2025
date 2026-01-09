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
class Solution {
    public int findHeight(TreeNode root) {
        int height = 0;

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            height++;
        }
        return height;
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        if (leftHeight == rightHeight) {
            return root;
        } else if (leftHeight > rightHeight) {
            return subtreeWithAllDeepest(root.left);
        } else {
            return subtreeWithAllDeepest(root.right);
        }
    }
}
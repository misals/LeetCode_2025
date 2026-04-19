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
    public TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode ans = root;

        if (root == null) {
            return new TreeNode(val);
        }

        while (root != null) {
            if (root.left == null && root.right == null) {
                if (val < root.val) {
                    root.left = new TreeNode(val);
                } else {
                    root.right = new TreeNode(val);
                }
                return ans;
            } else if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return ans;
    }
}
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
    public void inoderTraversal(String s, List<String> ans, TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            s = s + Integer.toString(node.val);
            ans.add(s);
            return;
        }
        s = s + Integer.toString(node.val) + "->";
        inoderTraversal(s, ans, node.left);
        inoderTraversal(s, ans, node.right);

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        inoderTraversal("", ans, root);
        return ans;
    }
}
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
    public void binaryTreePaths(TreeNode root, String s, List<String> ans) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            s = s + Integer.toString(root.val);
            ans.add(s);
            return;
        }

        s = s + Integer.toString(root.val) + "->";
        binaryTreePaths(root.left, s, ans);
        binaryTreePaths(root.right, s, ans);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();

        binaryTreePaths(root, "", ans);

        return ans;
    }
}
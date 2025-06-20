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
    public void traverseTree(List<Integer> ans, TreeNode root) {
        if (root == null) {
            return;
        }
        traverseTree(ans, root.left);
        ans.add(root.val);
        traverseTree(ans, root.right);
    }
 
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        traverseTree(ans, root);

        return ans;
    }
}
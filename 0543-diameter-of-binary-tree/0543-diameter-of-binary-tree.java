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
    public int findMax(TreeNode root, int[] ans) {
        if (root == null) {
            return 0;
        }
         
        int lh = findMax(root.left, ans);
        int rh = findMax(root.right, ans);

        ans[0] = Math.max(ans[0], lh + rh);

        return 1 + Math.max(lh, rh);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[1];
        findMax(root, ans);

        return ans[0];
    }
}
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
    public int findMaxPath(int[] maxi, TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(0, findMaxPath(maxi, root.left));
        int rightSum = Math.max(0, findMaxPath(maxi, root.right));

        maxi[0] = Math.max(maxi[0], root.val + leftSum + rightSum);

        return root.val + Math.max(leftSum, rightSum);
    }

    public int maxPathSum(TreeNode root) {
        int[] maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        findMaxPath(maxi, root);

        return maxi[0];
    }
}
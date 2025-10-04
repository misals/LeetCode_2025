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
    public int findMaxPath(TreeNode root, int[] maxi) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(0, findMaxPath(root.left, maxi));
        int rightSum = Math.max(0, findMaxPath(root.right, maxi));

        maxi[0] = Math.max(maxi[0], root.val + leftSum + rightSum);

        return root.val + Math.max(rightSum, leftSum);
    }

    public int maxPathSum(TreeNode root) {
        int[] maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;

        findMaxPath(root, maxi);
        return maxi[0];
    }
}
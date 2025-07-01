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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(inorder, 0, n - 1, postorder, 0, n - 1, inMap);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inMap) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = inMap.get(postorder[postEnd]);
        int numsLeft = inEnd - inRoot;

        root.left = buildTree(inorder, inStart, inRoot - 1, postorder, postStart, postEnd - numsLeft - 1, inMap);

        root.right = buildTree(inorder, inRoot + 1, inEnd, postorder, postEnd - numsLeft, postEnd - 1, inMap);

        return root;
    }
}
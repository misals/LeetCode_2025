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
    public void traverseBST(TreeNode root, List<Integer> list) {
        if (root == null) {
            return ;
        }
        traverseBST(root.left, list);
        list.add(root.val);
        traverseBST(root.right, list);
    }

    public TreeNode constructBST(int low, int high, List<Integer> list) {
        if (low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;

        TreeNode node = new TreeNode(list.get(mid));
        node.left = constructBST(low, mid - 1, list);
        node.right = constructBST(mid + 1, high, list);

        return node;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        traverseBST(root, list);

        return constructBST(0, list.size() - 1, list);
    }
}
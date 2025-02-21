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
class FindElements {
    TreeNode groot;
    public FindElements(TreeNode root) {
        if (root != null && root.val == -1) {
            root.val = 0;
        }
        solve(root);
        groot = root;
    }
    
    public boolean find(int target) {
        TreeNode node = new TreeNode();
        node = groot;
        return findElement(node, target);
    }

    void solve(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            node.left.val = 2 * node.val + 1;
        }
        if (node.right != null) {
            node.right.val = 2 * node.val + 2;
        }
        solve(node.left);
        solve(node.right);
    }

    public boolean findElement(TreeNode node, int target) {
        if (node == null) {
            return false;
        }
        if (node.val == target) {
            return true;
        }

        if (findElement(node.left, target) || findElement(node.right, target)) {
            return true;
        }
        return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
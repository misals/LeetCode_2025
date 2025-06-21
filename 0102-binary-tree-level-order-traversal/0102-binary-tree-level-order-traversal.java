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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> stack = new LinkedList<>();
        
        if (root != null) {
            stack.add(root);
        }

        while (!stack.isEmpty()) {
            List<Integer> temp = new ArrayList<>();

            int n = stack.size();

            for (int i = 0; i < n; i++) {
                TreeNode tempNode = stack.poll();

                temp.add(tempNode.val);

                if (tempNode.left != null) {
                    stack.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    stack.add(tempNode.right);
                }
            }

            ans.add(temp);
        }
        return ans;
    }
}
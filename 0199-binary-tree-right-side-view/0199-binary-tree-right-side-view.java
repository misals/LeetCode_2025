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
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> mp = new HashMap<>();

        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
        }

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();

                mp.put(level, node.val);

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            level++;
        }
        
        List<Integer> ans = new ArrayList<>();

        for (Integer val : mp.values()) {
            ans.add(val);
        }

        return ans;
    }
}
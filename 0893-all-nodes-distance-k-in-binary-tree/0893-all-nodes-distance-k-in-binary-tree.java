/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParents(Map<TreeNode, TreeNode> parent_track, TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.left != null) {
                parent_track.put(node.left, node);
                q.offer(node.left);
            }

            if (node.right != null) {
                parent_track.put(node.right, node);
                q.offer(node.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParents(parent_track, root);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);

        Map<TreeNode, Boolean> vis = new HashMap<>();
        vis.put(target, true);

        int level = 0;

        while (!q.isEmpty()) {
            int n = q.size();

            if (level == k) {
                break;
            }

            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();

                if (node.left != null && vis.get(node.left) == null) {
                    q.offer(node.left);
                    vis.put(node.left, true);
                }

                if (node.right != null && vis.get(node.right) == null) {
                    q.offer(node.right);
                    vis.put(node.right, true);
                }

                if (parent_track.get(node) != null && vis.get(parent_track.get(node)) == null) {
                    q.offer(parent_track.get(node));
                    vis.put(parent_track.get(node), true);
                }
            }
            level++;
        }

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }

        return ans;
    }
}
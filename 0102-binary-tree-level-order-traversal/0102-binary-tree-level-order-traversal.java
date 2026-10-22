import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            // Get the number of nodes at this level.
            int lvl = queue.size();

            List<Integer> level = new ArrayList<>();

            // Process all nodes belonging to this level.
            for (int i = 0; i < lvl; i++) {
                TreeNode current = queue.poll();

                level.add(current.val);

                // Add children for the next level.
                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            // Save the completed level.
            result.add(level);
        }

        return result;
    }
}
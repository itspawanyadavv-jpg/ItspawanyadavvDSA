
class Solution {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        // Handle empty tree
        if (root == null) {
            return result;
        }

        // Queue for level-order traversal
        Queue<TreeNode> queue = new LinkedList<>();

        // Start with the root
        queue.offer(root);

        // Process all levels
        while (!queue.isEmpty()) {

            // Number of nodes in the current level
            int size = queue.size();

            // Process every node at this level
            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                // Last node of this level is visible
                if (i == size - 1) {
                    result.add(current.val);
                }

                // Add left child first
                if (current.left != null) {
                    queue.offer(current.left);
                }

                // Add right child second
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return result;
    }
}

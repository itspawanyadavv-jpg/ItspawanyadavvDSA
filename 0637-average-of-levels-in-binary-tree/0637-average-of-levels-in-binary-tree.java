class Solution {

    public List<Double> averageOfLevels(TreeNode root) {

        // Stores the final averages
        List<Double> result = new ArrayList<>();

        // Queue used for BFS
        Queue<TreeNode> queue = new LinkedList<>();

        // Start BFS with the root
        queue.offer(root);

        // Continue until there are no more nodes
        while (!queue.isEmpty()) {

            // Number of nodes present at the current level
            int size = queue.size();

            // Sum of values at the current level
            long sum = 0;

            // Process only the nodes of this level
            for (int i = 0; i < size; i++) {

                // Remove the front node
                TreeNode current = queue.poll();

                // Add its value to the level sum
                sum += current.val;

                // Add left child to the queue
                if (current.left != null) {
                    queue.offer(current.left);
                }

                // Add right child to the queue
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            // Calculate average for this level
            double average = (double) sum / size;

            // Store the average
            result.add(average);
        }

        return result;
    }
}
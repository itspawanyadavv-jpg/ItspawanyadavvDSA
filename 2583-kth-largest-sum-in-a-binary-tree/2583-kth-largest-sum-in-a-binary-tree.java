
import java.util.*;

class Solution {

    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Long> levelSums = new ArrayList<>();

        queue.offer(root);

        // Process the tree one level at a time.
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long levelSum = 0L;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            levelSums.add(levelSum);
        }

        // Fewer than k levels means no kth largest sum exists.
        if (levelSums.size() < k) {
            return -1L;
        }

        // Sort level sums in ascending order.
        Collections.sort(levelSums);

        // kth largest is at index size - k.
        return levelSums.get(levelSums.size() - k);
    }
}

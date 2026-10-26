
import java.util.*;

class Solution {

    public long kthLargestLevelSum(TreeNode root, int k) {

        Queue<TreeNode> queue = new LinkedList<>();

        // Min-heap: keeps only the k largest level sums.
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        queue.offer(root);
        int levelCount = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long levelSum = 0L;

            // Calculate the sum of the current level.
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

            levelCount++;

            // Keep this level sum among the k largest.
            minHeap.offer(levelSum);

            // Remove the smallest if we have too many.
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Not enough levels to have a kth largest sum.
        if (levelCount < k) {
            return -1L;
        }

        // The smallest retained sum is the kth largest.
        return minHeap.peek();
    }
}

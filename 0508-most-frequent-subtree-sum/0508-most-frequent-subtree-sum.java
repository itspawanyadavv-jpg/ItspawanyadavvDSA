
import java.util.*;

class Solution {

    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> sums = new ArrayList<>();

        // Calculate the sum of every subtree independently.
        collectSums(root, sums);

        if (sums.isEmpty()) {
            return new int[0];
        }

        int maxFrequency = 0;
        List<Integer> answer = new ArrayList<>();

        // Count each sum by checking the entire list.
        for (int i = 0; i < sums.size(); i++) {
            int frequency = 0;

            for (int j = 0; j < sums.size(); j++) {
                if (sums.get(i).equals(sums.get(j))) {
                    frequency++;
                }
            }

            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                answer.clear();
                answer.add(sums.get(i));
            } else if (frequency == maxFrequency
                    && !answer.contains(sums.get(i))) {
                answer.add(sums.get(i));
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private void collectSums(TreeNode node, List<Integer> sums) {
        if (node == null) {
            return;
        }

        // Recalculate the complete subtree sum at this node.
        sums.add(calculateSum(node));

        collectSums(node.left, sums);
        collectSums(node.right, sums);
    }

    private int calculateSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return node.val
                + calculateSum(node.left)
                + calculateSum(node.right);
    }
}

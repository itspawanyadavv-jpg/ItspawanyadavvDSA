import java.util.*;

class Solution {

    private int count = 0;

    public int goodNodes(TreeNode root) {
        count = 0;

        List<Integer> path = new ArrayList<>();

        dfs(root, path);

        return count;
    }

    private void dfs(TreeNode node, List<Integer> path) {

        if (node == null) {
            return;
        }

        // Add current node to the path.
        path.add(node.val);

        // Find maximum value in the current path.
        int maxValue = Integer.MIN_VALUE;

        for (int value : path) {
            maxValue = Math.max(maxValue, value);
        }

        // Check whether current node is good.
        if (node.val == maxValue) {
            count++;
        }

        dfs(node.left, path);
        dfs(node.right, path);

        // Backtrack: remove current node.
        path.remove(path.size() - 1);
    }
}
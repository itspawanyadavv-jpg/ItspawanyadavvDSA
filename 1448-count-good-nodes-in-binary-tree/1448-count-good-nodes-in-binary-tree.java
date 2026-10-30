class Solution {

    private int count = 0;

    public int goodNodes(TreeNode root) {

        count = 0;

        dfs(root, Integer.MIN_VALUE);

        return count;
    }

    private void dfs(TreeNode node, int maxSoFar) {

        // Base case: no node exists.
        if (node == null) {
            return;
        }

        // Check whether the current node is good.
        if (node.val >= maxSoFar) {
            count++;
        }

        // Update maximum for the current path.
        int newMax = Math.max(maxSoFar, node.val);

        // Explore the left subtree.
        dfs(node.left, newMax);

        // Explore the right subtree.
        dfs(node.right, newMax);
    }
}
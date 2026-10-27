class Solution {

    private int maxDepth = -1;
    private int deepestSum = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return deepestSum;
    }

    private void dfs(TreeNode node, int depth) {

        // Base case: no node exists.
        if (node == null) {
            return;
        }

        // Process only leaf nodes.
        if (node.left == null && node.right == null) {

            // Found a new deepest level.
            if (depth > maxDepth) {
                maxDepth = depth;
                deepestSum = node.val;
            }

            // Found another leaf at the deepest level.
            else if (depth == maxDepth) {
                deepestSum += node.val;
            }
        }

        // Explore the left subtree.
        dfs(node.left, depth + 1);

        // Explore the right subtree.
        dfs(node.right, depth + 1);
    }
}
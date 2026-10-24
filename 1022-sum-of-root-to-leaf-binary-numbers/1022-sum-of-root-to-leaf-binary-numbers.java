class Solution {
    private int total = 0;

    public int sumRootToLeaf(TreeNode root) {
        total = 0;
        dfs(root, "");
        return total;
    }

    private void dfs(TreeNode node, String path) {
        if (node == null) {
            return;
        }

        // Append this node's binary digit.
        path = path + node.val;

        // Convert and add only at a leaf.
        if (node.left == null && node.right == null) {
            total += Integer.parseInt(path, 2);
            return;
        }

        dfs(node.left, path);
        dfs(node.right, path);
    }
}
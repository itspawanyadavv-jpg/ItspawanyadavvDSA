class Solution {

    class Result {
        TreeNode lca;
        int depth;

        Result(TreeNode lca, int depth) {
            this.lca = lca;
            this.depth = depth;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).lca;
    }

    private Result dfs(TreeNode node) {

        // Base case: empty subtree
        if (node == null) {
            return new Result(null, 0);
        }

        // Get information from both children
        Result left = dfs(node.left);
        Result right = dfs(node.right);

        // Left subtree is deeper
        if (left.depth > right.depth) {
            return new Result(left.lca, left.depth + 1);
        }

        // Right subtree is deeper
        if (right.depth > left.depth) {
            return new Result(right.lca, right.depth + 1);
        }

        // Both sides have equal maximum depth
        return new Result(node, left.depth + 1);
    }
}
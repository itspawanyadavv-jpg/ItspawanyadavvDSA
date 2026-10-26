class Solution {

    private int total;

    public int sumEvenGrandparent(TreeNode root) {
        total = 0;
        dfs(root);
        return total;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        // If this node is even, add its grandchildren.
        if (node.val % 2 == 0) {

            if (node.left != null) {
                if (node.left.left != null) {
                    total += node.left.left.val;
                }
                if (node.left.right != null) {
                    total += node.left.right.val;
                }
            }

            if (node.right != null) {
                if (node.right.left != null) {
                    total += node.right.left.val;
                }
                if (node.right.right != null) {
                    total += node.right.right.val;
                }
            }
        }

        dfs(node.left);
        dfs(node.right);
    }
}
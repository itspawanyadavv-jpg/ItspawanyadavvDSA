class Solution {

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Check the current node.
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        // Check both subtrees.
        return isBalanced(root.left)
            && isBalanced(root.right);
    }

    private int height(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
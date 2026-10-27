class Solution {

    public boolean isSymmetric(TreeNode root) {
        // An empty tree is symmetric.
        if (root == null) {
            return true;
        }

        // Compare the left and right subtrees as mirrors.
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {

        // Both nodes are absent: they match.
        if (left == null && right == null) {
            return true;
        }

        // Only one node is absent: they do not match.
        if (left == null || right == null) {
            return false;
        }

        // Values must match.
        if (left.val != right.val) {
            return false;
        }

        // Compare opposite children.
        return isMirror(left.left, right.right)
            && isMirror(left.right, right.left);
    }
}
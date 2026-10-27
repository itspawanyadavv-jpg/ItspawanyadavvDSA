class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Both nodes are null: this part matches.
        if (p == null && q == null) {
            return true;
        }

        // Only one node is null: structures differ.
        if (p == null || q == null) {
            return false;
        }

        // Values differ: trees are not identical.
        if (p.val != q.val) {
            return false;
        }

        // Both left and right subtrees must match.
        return isSameTree(p.left, q.left)
            && isSameTree(p.right, q.right);
    }
}
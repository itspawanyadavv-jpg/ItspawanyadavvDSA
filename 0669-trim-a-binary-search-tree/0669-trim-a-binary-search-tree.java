class Solution {

    public TreeNode trimBST(TreeNode root, int low, int high) {

        // Base case.
        if (root == null) {
            return null;
        }

        // First trim the left subtree.
        TreeNode leftSubtree = trimBST(root.left, low, high);

        // Then trim the right subtree.
        TreeNode rightSubtree = trimBST(root.right, low, high);

        // Case 1: Current node is smaller than low.
        if (root.val < low) {
            return rightSubtree;
        }

        // Case 2: Current node is greater than high.
        if (root.val > high) {
            return leftSubtree;
        }

        // Case 3: Current node is valid.
        root.left = leftSubtree;
        root.right = rightSubtree;

        return root;
    }
}
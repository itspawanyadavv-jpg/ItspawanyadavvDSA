class Solution {

    public TreeNode trimBST(TreeNode root, int low, int high) {

        // Base case: empty subtree.
        if (root == null) {
            return null;
        }

        // Case 1: Current node is smaller than low.
        if (root.val < low) {

            // Discard current node and its left subtree.
            return trimBST(root.right, low, high);
        }

        // Case 2: Current node is greater than high.
        if (root.val > high) {

            // Discard current node and its right subtree.
            return trimBST(root.left, low, high);
        }

        // Case 3: Current node is valid.
        // Trim and reconnect the left subtree.
        root.left = trimBST(root.left, low, high);

        // Trim and reconnect the right subtree.
        root.right = trimBST(root.right, low, high);

        // Return the current node as the subtree root.
        return root;
    }
}
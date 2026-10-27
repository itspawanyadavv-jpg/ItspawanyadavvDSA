class Solution {

    public TreeNode invertTree(TreeNode root) {

        // Base case: nothing to invert.
        if (root == null) {
            return null;
        }

        // Swap the left and right children.
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Invert both subtrees.
        invertTree(root.left);
        invertTree(root.right);

        // Return the root of the inverted tree.
        return root;
    }
}
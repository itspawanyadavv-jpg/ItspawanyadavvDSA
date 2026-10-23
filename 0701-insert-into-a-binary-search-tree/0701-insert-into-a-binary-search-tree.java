
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        // An empty position is where the new node belongs.
        if (root == null) {
            return new TreeNode(val);
        }

        // Smaller values belong in the left subtree.
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }

        // Larger values belong in the right subtree.
        else {
            root.right = insertIntoBST(root.right, val);
        }

        // Preserve and return the current subtree's root.
        return root;
    }
}

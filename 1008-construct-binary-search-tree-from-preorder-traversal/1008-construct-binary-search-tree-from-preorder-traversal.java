
class Solution {

    public TreeNode bstFromPreorder(int[] preorder) {

        if (preorder == null || preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        // Insert every remaining element
        for (int i = 1; i < preorder.length; i++) {
            insert(root, preorder[i]);
        }

        return root;
    }

    private TreeNode insert(TreeNode root, int value) {

        // Find the correct empty position
        if (value < root.val) {

            if (root.left == null) {
                root.left = new TreeNode(value);
            } else {
                insert(root.left, value);
            }

        } else {

            if (root.right == null) {
                root.right = new TreeNode(value);
            } else {
                insert(root.right, value);
            }
        }

        return root;
    }
}

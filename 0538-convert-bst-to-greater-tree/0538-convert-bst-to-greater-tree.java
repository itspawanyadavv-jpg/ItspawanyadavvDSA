class Solution {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {

        // Reset sum for a fresh execution.
        sum = 0;

        // Start Reverse Inorder Traversal.
        reverseInorder(root);

        return root;
    }

    private void reverseInorder(TreeNode root) {

        // Base case.
        if (root == null) {
            return;
        }

        // Step 1: Visit right subtree.
        reverseInorder(root.right);

        // Step 2: Add current original value to sum.
        sum += root.val;

        // Step 3: Update current node.
        root.val = sum;

        // Step 4: Visit left subtree.
        reverseInorder(root.left);
    }
}
class Solution {

    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // Calculate diameter passing through current node
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int currentDiameter = leftHeight + rightHeight;

        // Calculate diameter in left and right subtrees
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        // Return the maximum diameter
        return Math.max(
            currentDiameter,
            Math.max(leftDiameter, rightDiameter)
        );
    }

    // Calculates height in number of edges
    private int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return 1 + Math.max(
            height(root.left),
            height(root.right)
        );
    }
}
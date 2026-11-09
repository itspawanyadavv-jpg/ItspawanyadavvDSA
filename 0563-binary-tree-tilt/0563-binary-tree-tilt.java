class Solution {

    public int findTilt(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        int currentTilt = Math.abs(leftSum - rightSum);

        int leftTilt = findTilt(root.left);
        int rightTilt = findTilt(root.right);

        return currentTilt + leftTilt + rightTilt;
    }

    private int sum(TreeNode node) {

        if (node == null) {
            return 0;
        }

        return node.val
             + sum(node.left)
             + sum(node.right);
    }
}
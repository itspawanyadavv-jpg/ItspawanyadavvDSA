class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        // Case 1: No node means no valid path.
        if (root == null) {
            return false;
        }

        // Case 2: A leaf must exactly match the target.
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // Case 3: Remove the current node's value.
        int remainingSum = targetSum - root.val;

        // Case 4: Search either subtree.
        return hasPathSum(root.left, remainingSum)
            || hasPathSum(root.right, remainingSum);
    }
}
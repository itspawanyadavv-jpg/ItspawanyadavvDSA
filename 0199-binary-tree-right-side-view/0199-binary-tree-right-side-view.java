
class Solution {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // Calculate the height of the tree
        int height = getHeight(root);

        // Find the rightmost node at every level
        for (int level = 0; level < height; level++) {

            Integer rightmost = findRightmost(root, level);

            result.add(rightmost);
        }

        return result;
    }

    private int getHeight(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return 1 + Math.max(
            getHeight(root.left),
            getHeight(root.right)
        );
    }

    private Integer findRightmost(TreeNode root, int level) {

        // No node exists at this position
        if (root == null) {
            return null;
        }

        // Reached the required level
        if (level == 0) {
            return root.val;
        }

        // Search right subtree first
        Integer rightResult =
            findRightmost(root.right, level - 1);

        if (rightResult != null) {
            return rightResult;
        }

        // If right subtree has no node at this level,
        // search the left subtree
        return findRightmost(root.left, level - 1);
    }
}

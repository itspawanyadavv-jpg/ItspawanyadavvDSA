class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {

        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {

        // Base case: No elements are available.
        if (left > right) {
            return null;
        }

        // Find the middle index.
        int mid = left + (right - left) / 2;

        // Create the root node using the middle element.
        TreeNode root = new TreeNode(nums[mid]);

        // Build the left subtree.
        root.left = buildTree(nums, left, mid - 1);

        // Build the right subtree.
        root.right = buildTree(nums, mid + 1, right);

        // Return the root of the current subtree.
        return root;
    }
}
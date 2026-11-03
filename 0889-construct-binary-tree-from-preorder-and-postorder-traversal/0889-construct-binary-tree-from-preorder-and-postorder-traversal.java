
class Solution {

    public TreeNode constructFromPrePost(
        int[] preorder,
        int[] postorder
    ) {

        if (preorder.length == 0) {
            return null;
        }

        // First preorder element is root
        TreeNode root = new TreeNode(preorder[0]);

        // Single-node subtree
        if (preorder.length == 1) {
            return root;
        }

        // Second preorder element is left subtree root
        int leftRoot = preorder[1];

        // Find left subtree root in postorder
        int index = 0;

        while (postorder[index] != leftRoot) {
            index++;
        }

        // Calculate left subtree size
        int leftSize = index + 1;

        // Divide preorder
        int[] leftPre =
            Arrays.copyOfRange(preorder, 1, 1 + leftSize);

        int[] rightPre =
            Arrays.copyOfRange(preorder, 1 + leftSize,
                               preorder.length);

        // Divide postorder
        int[] leftPost =
            Arrays.copyOfRange(postorder, 0, leftSize);

        int[] rightPost =
            Arrays.copyOfRange(postorder, leftSize,
                               postorder.length - 1);

        // Recursively construct subtrees
        root.left = constructFromPrePost(leftPre, leftPost);

        root.right = constructFromPrePost(rightPre, rightPost);

        return root;
    }
}


class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder == null || postorder == null ||
            inorder.length == 0 ||
            inorder.length != postorder.length) {
            return null;
        }

        // Last postorder element is the root
        int rootValue = postorder[postorder.length - 1];

        TreeNode root = new TreeNode(rootValue);

        // Find root position in inorder
        int rootIndex = 0;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        // Number of nodes in left subtree
        int leftSize = rootIndex;

        // Divide inorder
        int[] leftInorder =
            Arrays.copyOfRange(inorder, 0, rootIndex);

        int[] rightInorder =
            Arrays.copyOfRange(inorder, rootIndex + 1,
                               inorder.length);

        // Divide postorder
        int[] leftPostorder =
            Arrays.copyOfRange(postorder, 0, leftSize);

        int[] rightPostorder =
            Arrays.copyOfRange(postorder, leftSize,
                               postorder.length - 1);

        // IMPORTANT: Construct right subtree first
        root.right = buildTree(rightInorder, rightPostorder);

        // Then construct left subtree
        root.left = buildTree(leftInorder, leftPostorder);

        return root;
    }
}

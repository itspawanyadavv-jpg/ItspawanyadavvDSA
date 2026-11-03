
class Solution {

    // Maps each inorder value to its index
    private Map<Integer, Integer> indexMap;

    // Tracks the next element from postorder
    private int postorderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // Handle empty or invalid input
        if (inorder == null || postorder == null ||
            inorder.length == 0 ||
            inorder.length != postorder.length) {
            return null;
        }

        indexMap = new HashMap<>();

        // Store inorder value -> index
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        // Start from the last postorder element
        postorderIndex = postorder.length - 1;

        // Initially, the entire inorder array is our tree
        return construct(
            postorder,
            0,
            inorder.length - 1
        );
    }

    private TreeNode construct(
        int[] postorder,
        int inLeft,
        int inRight
    ) {

        // No elements in this subtree
        if (inLeft > inRight) {
            return null;
        }

        // Last unused postorder element is the root
        int rootValue = postorder[postorderIndex--];

        TreeNode root = new TreeNode(rootValue);

        // Find root position in inorder
        int mid = indexMap.get(rootValue);

        // Construct RIGHT subtree first
        root.right = construct(
            postorder,
            mid + 1,
            inRight
        );

        // Then construct LEFT subtree
        root.left = construct(
            postorder,
            inLeft,
            mid - 1
        );

        return root;
    }
}

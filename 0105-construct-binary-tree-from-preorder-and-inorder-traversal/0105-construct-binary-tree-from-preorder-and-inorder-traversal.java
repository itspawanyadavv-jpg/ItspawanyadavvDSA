
class Solution {

    // Maps each inorder value to its index
    private Map<Integer, Integer> indexMap;

    // Tracks the next element to consume from preorder
    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Handle empty input
        if (preorder == null || inorder == null ||
            preorder.length == 0 ||
            preorder.length != inorder.length) {
            return null;
        }

        indexMap = new HashMap<>();

        // Store value -> index for inorder
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        // Start from the first preorder element
        preorderIndex = 0;

        // Initially, the entire inorder array is our subtree
        return construct(preorder, 0, inorder.length - 1);
    }

    private TreeNode construct(
        int[] preorder,
        int inLeft,
        int inRight
    ) {

        // No elements in this subtree
        if (inLeft > inRight) {
            return null;
        }

        // First unused preorder element is the root
        int rootValue = preorder[preorderIndex++];

        TreeNode root = new TreeNode(rootValue);

        // Find root position in inorder in O(1) expected time
        int mid = indexMap.get(rootValue);

        // Construct left subtree first
        root.left = construct(
            preorder,
            inLeft,
            mid - 1
        );

        // Construct right subtree
        root.right = construct(
            preorder,
            mid + 1,
            inRight
        );

        return root;
    }
}


class Solution {

    public TreeNode sortedListToBST(ListNode head) {

        // Step 1: Copy linked list values into an ArrayList
        List<Integer> values = new ArrayList<>();

        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        // Step 2: Build BST using array indices
        return buildBST(values, 0, values.size() - 1);
    }

    private TreeNode buildBST(
        List<Integer> values,
        int left,
        int right
    ) {

        // Base case: No elements available
        if (left > right) {
            return null;
        }

        // Find middle index
        int mid = left + (right - left) / 2;

        // Create root node
        TreeNode root = new TreeNode(values.get(mid));

        // Build left subtree
        root.left = buildBST(values, left, mid - 1);

        // Build right subtree
        root.right = buildBST(values, mid + 1, right);

        return root;
    }
}


class Solution {

    // Shared pointer to the current linked-list node
    private ListNode current;

    public TreeNode sortedListToBST(ListNode head) {

        // Initially, current points to the list's head
        current = head;

        // Count the total number of nodes
        int size = 0;

        ListNode temp = head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // Construct the balanced BST
        return buildBST(size);
    }

    private TreeNode buildBST(int size) {

        // Base case: No nodes available
        if (size <= 0) {
            return null;
        }

        // Step 1: Construct left subtree
        int leftSize = size / 2;

        TreeNode leftSubtree = buildBST(leftSize);

        // Step 2: Current linked-list node becomes root
        TreeNode root = new TreeNode(current.val);

        // Move linked-list pointer forward
        current = current.next;

        // Step 3: Construct right subtree
        int rightSize = size - leftSize - 1;

        root.left = leftSubtree;
        root.right = buildBST(rightSize);

        return root;
    }
}

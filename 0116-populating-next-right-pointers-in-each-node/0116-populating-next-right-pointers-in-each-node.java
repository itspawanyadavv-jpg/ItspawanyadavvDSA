class Solution {

    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Node leftmost = root;

        // Move level by level
        while (leftmost.left != null) {

            Node current = leftmost;

            // Traverse current level using next pointers
            while (current != null) {

                // Connect left child to right child
                current.left.next = current.right;

                // Connect right child to next parent's left child
                if (current.next != null) {
                    current.right.next = current.next.left;
                }

                // Move to next node in current level
                current = current.next;
            }

            // Move down to the next level
            leftmost = leftmost.left;
        }

        return root;
    }
}
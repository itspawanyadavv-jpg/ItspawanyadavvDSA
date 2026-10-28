class Solution {

    public Node connect(Node root) {
        // An empty tree has nothing to connect.
        if (root == null) {
            return null;
        }

        // Start with the root level.
        Node leftmost = root;

        // Process one level at a time.
        while (leftmost.left != null) {
            Node current = leftmost;

            // Traverse this level using existing next pointers.
            while (current != null) {

                // Connect the two children of the same parent.
                current.left.next = current.right;

                // Connect children across neighboring parents.
                if (current.next != null) {
                    current.right.next = current.next.left;
                }

                // Move to the next parent on this level.
                current = current.next;
            }

            // Move down to the next level's leftmost node.
            leftmost = leftmost.left;
        }

        return root;
    }
}
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // Number of nodes in this level.
            int levelSize = queue.size();

            Node previous = null;

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();

                // Connect the previous node to the current node.
                if (previous != null) {
                    previous.next = current;
                }

                previous = current;

                // Add children for the next level.
                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            // The last node at this level points to null.
            previous.next = null;
        }

        return root;
    }
}
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
            int levelSize = queue.size();
            Node previous = null;

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();

                if (previous != null) {
                    previous.next = current;
                }

                previous = current;

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            // Terminate the current level.
            previous.next = null;
        }

        return root;
    }
}
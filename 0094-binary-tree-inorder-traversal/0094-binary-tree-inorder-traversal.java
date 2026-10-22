import java.util.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            // Step 1: Go as far left as possible.
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Step 2: Process the most recently saved node.
            current = stack.pop();
            result.add(current.val);

            // Step 3: Explore its right subtree.
            current = current.right;
        }

        return result;
    }
}
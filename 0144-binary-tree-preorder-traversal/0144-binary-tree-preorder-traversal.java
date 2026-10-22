import java.util.*;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        if (root == null) {
            return result;
        }

        stack.push(root);

        while (!stack.isEmpty()) {

            // Step 1: Process the current node first.
            TreeNode current = stack.pop();
            result.add(current.val);

            // Step 2: Push the right child first.
            if (current.right != null) {
                stack.push(current.right);
            }

            // Step 3: Push the left child second.
            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return result;
    }
}
class Solution {

    public List<Integer> preorder(Node root) {

        // Stores the preorder traversal
        List<Integer> result = new ArrayList<>();

        // Edge case: empty tree
        if (root == null) {
            return result;
        }

        // Stack helps us simulate recursion
        Stack<Node> stack = new Stack<>();

        // Start with the root
        stack.push(root);

        while (!stack.isEmpty()) {

            // Get the next node to process
            Node node = stack.pop();

            // Preorder: process node BEFORE its children
            result.add(node.val);

            // Stack is LIFO,
            // so push children from RIGHT to LEFT.
            for (int i = node.children.size() - 1; i >= 0; i--) {

                stack.push(node.children.get(i));
            }
        }

        return result;
    }
}
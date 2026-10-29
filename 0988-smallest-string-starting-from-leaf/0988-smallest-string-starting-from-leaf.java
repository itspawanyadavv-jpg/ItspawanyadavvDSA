
import java.util.*;

class Solution {

    private String smallest;

    public String smallestFromLeaf(TreeNode root) {
        smallest = null;

        List<Character> path = new ArrayList<>();
        dfs(root, path);

        return smallest;
    }

    private void dfs(TreeNode node, List<Character> path) {
        if (node == null) {
            return;
        }

        // Convert the current node value into a character.
        char letter = (char) ('a' + node.val);
        path.add(letter);

        // A leaf gives us one candidate string.
        if (node.left == null && node.right == null) {
            StringBuilder candidate = new StringBuilder();

            // Read the path backward: leaf to root.
            for (int i = path.size() - 1; i >= 0; i--) {
                candidate.append(path.get(i));
            }

            String current = candidate.toString();

            if (smallest == null
                    || current.compareTo(smallest) < 0) {
                smallest = current;
            }
        } else {
            dfs(node.left, path);
            dfs(node.right, path);
        }

        // Backtrack: remove the current node's letter.
        path.remove(path.size() - 1);
    }
}

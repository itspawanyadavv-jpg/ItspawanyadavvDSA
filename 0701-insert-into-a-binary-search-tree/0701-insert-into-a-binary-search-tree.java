import java.util.*;

class Solution {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        List<Integer> values = new ArrayList<>();

        // Collect the existing values.
        collectValues(root, values);

        // Add the new value and sort.
        values.add(val);
        Collections.sort(values);

        // Rebuild a balanced BST.
        return buildBST(values, 0, values.size() - 1);
    }

    private void collectValues(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }

        values.add(node.val);
        collectValues(node.left, values);
        collectValues(node.right, values);
    }

    private TreeNode buildBST(
            List<Integer> values, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(values.get(mid));

        node.left = buildBST(values, left, mid - 1);
        node.right = buildBST(values, mid + 1, right);

        return node;
    }
}
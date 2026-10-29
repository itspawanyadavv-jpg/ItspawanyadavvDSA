
import java.util.*;

class Solution {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> allNodes = new ArrayList<>();
        Map<TreeNode, TreeNode> parent = new IdentityHashMap<>();

        // Collect all nodes and remember their parents.
        collectNodes(root, null, allNodes, parent);

        // Find and delete each requested value.
        for (int value : to_delete) {
            TreeNode target = null;

            // Brute-force search through all nodes.
            for (TreeNode node : allNodes) {
                if (node != null && node.val == value) {
                    target = node;
                    break;
                }
            }

            if (target == null) {
                continue;
            }

            TreeNode p = parent.get(target);

            // Disconnect the target from its parent.
            if (p != null) {
                if (p.left == target) {
                    p.left = null;
                } else if (p.right == target) {
                    p.right = null;
                }
            }

            // A surviving child may become a forest root.
            if (target.left != null) {
                parent.put(target.left, null);
            }
            if (target.right != null) {
                parent.put(target.right, null);
            }

            // Mark this node as deleted.
            int index = allNodes.indexOf(target);
            if (index != -1) {
                allNodes.set(index, null);
            }
        }

        List<TreeNode> forest = new ArrayList<>();

        // The original root survives if it was not deleted.
        if (root != null && allNodes.contains(root)) {
            if (parent.get(root) == null) {
                forest.add(root);
            }
        }

        // Find surviving nodes with no parent.
        for (TreeNode node : allNodes) {
            if (node != null && parent.get(node) == null
                    && node != root) {
                forest.add(node);
            }
        }

        return forest;
    }

    private void collectNodes(
            TreeNode node,
            TreeNode p,
            List<TreeNode> allNodes,
            Map<TreeNode, TreeNode> parent) {

        if (node == null) {
            return;
        }

        allNodes.add(node);
        parent.put(node, p);

        collectNodes(node.left, node, allNodes, parent);
        collectNodes(node.right, node, allNodes, parent);
    }
}

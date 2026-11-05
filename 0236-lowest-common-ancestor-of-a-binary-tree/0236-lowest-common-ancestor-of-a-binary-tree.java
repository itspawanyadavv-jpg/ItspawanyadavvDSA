import java.util.*;

class Solution {

    // Finds the path from root to target
    boolean findPath(TreeNode root,
                     TreeNode target,
                     List<TreeNode> path) {

        if (root == null) {
            return false;
        }

        // Add current node to path
        path.add(root);

        // Target found
        if (root == target) {
            return true;
        }

        // Search left and right subtrees
        if (findPath(root.left, target, path) ||
            findPath(root.right, target, path)) {
            return true;
        }

        // Backtrack if target is not in this subtree
        path.remove(path.size() - 1);

        return false;
    }

    public TreeNode lowestCommonAncestor(
        TreeNode root,
        TreeNode p,
        TreeNode q
    ) {

        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();

        // Find both paths
        findPath(root, p, pathP);
        findPath(root, q, pathQ);

        TreeNode lca = null;

        // Find the common prefix
        int i = 0;

        while (i < pathP.size() &&
               i < pathQ.size() &&
               pathP.get(i) == pathQ.get(i)) {

            lca = pathP.get(i);
            i++;
        }

        return lca;
    }
}
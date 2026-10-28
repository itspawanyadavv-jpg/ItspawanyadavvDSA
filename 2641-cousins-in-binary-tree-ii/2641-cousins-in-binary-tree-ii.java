import java.util.*;

class Solution {

    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // The root has no cousins.
        root.val = 0;

        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            int nextLevelSum = 0;

            // Save the parents of the next level.
            List<TreeNode> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode parent = queue.poll();
                currentLevel.add(parent);

                if (parent.left != null) {
                    nextLevelSum += parent.left.val;
                    queue.offer(parent.left);
                }

                if (parent.right != null) {
                    nextLevelSum += parent.right.val;
                    queue.offer(parent.right);
                }
            }

            // Replace the values of children using the sibling-group sum.
            for (TreeNode parent : currentLevel) {

                int siblingSum = 0;

                if (parent.left != null) {
                    siblingSum += parent.left.val;
                }

                if (parent.right != null) {
                    siblingSum += parent.right.val;
                }

                if (parent.left != null) {
                    parent.left.val = nextLevelSum - siblingSum;
                }

                if (parent.right != null) {
                    parent.right.val = nextLevelSum - siblingSum;
                }
            }
        }

        return root;
    }
}
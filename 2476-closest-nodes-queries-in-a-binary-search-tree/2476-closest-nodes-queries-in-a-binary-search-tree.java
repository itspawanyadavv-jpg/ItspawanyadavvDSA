import java.util.*;

class Solution {

    public List<List<Integer>> closestNodes(
            TreeNode root, List<Integer> queries) {

        // Step 1: Collect BST values in sorted order.
        List<Integer> values = new ArrayList<>();
        inorder(root, values);

        List<List<Integer>> answer = new ArrayList<>();

        // Step 2: Answer each query using binary search.
        for (int query : queries) {

            // First index whose value is >= query.
            int index = lowerBound(values, query);

            int mini = -1;
            int maxi = -1;

            // Find the largest value <= query.
            if (index < values.size()
                    && values.get(index) == query) {
                mini = values.get(index);
            } else if (index > 0) {
                mini = values.get(index - 1);
            }

            // The lower bound is the smallest value >= query.
            if (index < values.size()) {
                maxi = values.get(index);
            }

            answer.add(Arrays.asList(mini, maxi));
        }

        return answer;
    }

    // Inorder traversal produces sorted values in a BST.
    private void inorder(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }

        inorder(node.left, values);
        values.add(node.val);
        inorder(node.right, values);
    }

    // Returns the first index with value >= target.
    // Returns values.size() if no such value exists.
    private int lowerBound(List<Integer> values, int target) {
        int left = 0;
        int right = values.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (values.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
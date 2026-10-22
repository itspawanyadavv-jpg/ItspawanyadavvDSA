
class Solution {

    static class Info {
        int val, row, col;

        Info(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

// BUG 1: Duplicate "class Solution" declaration.
// Remove this second declaration.
    // class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // BUG 2: result is used below but was never declared.
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        List<Info> nodes = new ArrayList<>();
        dfs(root, 0, 0, nodes);

        nodes.sort((a, b) -> {
            if (a.col != b.col) {
                return Integer.compare(a.col, b.col);
            }

            if (a.row != b.row) {

                // BUG 3: Missing "return".
                return Integer.compare(a.row, b.row);
            }

            return Integer.compare(a.val, b.val);
        });

        // Group nodes by column.
        int prevCol = nodes.get(0).col;

        // BUG 4: "Lsit" is misspelled.
        List<Integer> column = new ArrayList<>();

        for (Info node : nodes) {

            // BUG 5: "previCol" is misspelled.
            if (node.col != prevCol) {
                result.add(column);
                column = new ArrayList<>();
                prevCol = node.col;
            }

            column.add(node.val);
        }

        result.add(column);
        return result;
    }

    // BUG 6: "vouid" should be "void".
    // BUG 7: "ListNode<Info>" should be "List<Info>".
    private void dfs(TreeNode node, int row, int col,
                     List<Info> nodes) {

        if (node == null) {

            // BUG 8: dfs returns void, so use "return;",
            // not "return result;".
            return;
        }

        nodes.add(new Info(node.val, row, col));

        dfs(node.left, row + 1, col - 1, nodes);
        dfs(node.right, row + 1, col + 1, nodes);
    }
}

class Solution {

    public int sumOfLeftLeaves(TreeNode root) {

        // Base case:
        // If there is no node, there is nothing to add.
        if (root == null) {
            return 0;
        }

        int sum = 0;

        // Check whether the left child exists
        // and whether that left child is a leaf.
        if (root.left != null &&
            root.left.left == null &&
            root.left.right == null) {

            // The left child is a left leaf.
            sum += root.left.val;
        }

        // Recursively find left leaves in the left subtree.
        sum += sumOfLeftLeaves(root.left);

        // Recursively find left leaves in the right subtree.
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }
}
// FLOW 

// sumOfLeftLeaves(3)               
// │
// ├── Found left leaf 9
// │
// ├── sumOfLeftLeaves(9)
// │   ├── null → 0
// │   └── null → 0
// │
// └── sumOfLeftLeaves(20)
//     │
//     ├── Found left leaf 15
//     │
//     ├── sumOfLeftLeaves(15)
//     │   ├── null → 0
//     │   └── null → 0
//     │
//     └── sumOfLeftLeaves(7)
//         ├── null → 0
//         └── null → 0
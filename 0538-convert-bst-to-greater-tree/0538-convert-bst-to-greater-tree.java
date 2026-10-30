/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private long sum = 0;
    public TreeNode convertBST(TreeNode root) {

        sum = 0L;
        reverse(root);
        return root;

    }
    public void reverse(TreeNode root){
        if(root == null){
            return;
        }
        reverse(root.right);
        sum +=root.val;
        root.val = (int)sum;
        reverse(root.left);

    }

}
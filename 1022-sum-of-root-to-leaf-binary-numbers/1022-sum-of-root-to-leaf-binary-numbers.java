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
    
    private int helper(TreeNode root,int x){

        if(root == null){

            return 0;
        }

        x = x * 2 + root.val;

        if(root.left == null && root.right == null){

            return x;
        }

        int left = helper(root.left,x);
        int right = helper(root.right,x);

        return left + right;
    }
    public int sumRootToLeaf(TreeNode root) {
        
        return helper(root,0);
    }
}
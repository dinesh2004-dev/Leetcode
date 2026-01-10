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
 class Result{

    TreeNode node;
    int depth;

    public Result(TreeNode node,int depth){

        this.node = node;
        this.depth = depth;
    }
 }
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        
        return findLcaDeepestLeaves(root).node;
    }

    public Result findLcaDeepestLeaves(TreeNode root){

        if(root == null){

            return new Result(null,0);
        }

        Result left = findLcaDeepestLeaves(root.left);
        Result right = findLcaDeepestLeaves(root.right);

        if(left.depth > right.depth){

            return new Result(left.node,left.depth + 1);
        }
        else if(right.depth > left.depth){

            return new Result(right.node,right.depth + 1);
        }

        return new Result(root,left.depth + 1);
    }
}
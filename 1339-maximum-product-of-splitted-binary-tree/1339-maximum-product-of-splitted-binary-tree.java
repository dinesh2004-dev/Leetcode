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

    private static final int mod = (int) 1e9 + 7;

    public long findSum(TreeNode root){

        if(root == null){

            return 0;
        }

        return root.val + findSum(root.left) + findSum(root.right);
    }

    public long solve(TreeNode root,long[] maxSum,long totalSum){

        if(root == null){

            return 0;
        }

        long leftSum = solve(root.left,maxSum,totalSum);
        long rightSum = solve(root.right,maxSum,totalSum);

        long subTreeSum = leftSum + rightSum + root.val;

        long product = subTreeSum * (totalSum - subTreeSum);

        maxSum[0] = Math.max(maxSum[0],product);

        return subTreeSum;
    }
    public int maxProduct(TreeNode root) {

        long[] maxSum = {Integer.MIN_VALUE};

        long totalSum = findSum(root) % mod;

        solve(root,maxSum,totalSum);

        return (int) (maxSum[0] % mod);

    }
}
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
    public void solve(TreeNode root,int targetSum,int sum,List<List<Integer>> res,List<Integer> path){
        if(root == null){
            return;
        }
        sum += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null && sum == targetSum){
            res.add(new ArrayList<>(path));
        }
        solve(root.left,targetSum,sum,res,path);
        solve(root.right,targetSum,sum,res,path);

        path.remove(path.size() -1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        solve(root,targetSum,0,res,new ArrayList<>());
        return res;

    }
}
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
    private void findInorder(TreeNode root,List<TreeNode> list){

        if(root == null){

            return;
        }

        findInorder(root.left,list);
        list.add(root);
        findInorder(root.right,list);
    }
    private TreeNode balance(List<TreeNode> inorder,int l,int h){

        if(l > h){

            return null;
        }

        int mid = l + ( h - l) / 2;

        TreeNode node = inorder.get(mid);
        node.left = balance(inorder,l,mid - 1);
        node.right = balance(inorder,mid + 1,h);

        return node;
    }
    public TreeNode balanceBST(TreeNode root) {
        
        List<TreeNode> inorder = new ArrayList<>();
        findInorder(root,inorder);
        return balance(inorder,0,inorder.size() - 1);

    }
}
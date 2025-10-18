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
    public TreeNode construct(int[] preorder,int ps,int pe,int[] inorder
    ,int is,int ie,Map<Integer,Integer> mpp){

        if(ps > pe || is > ie){

            return null;
        }

        TreeNode newNode = new TreeNode(preorder[ps]);

        int inRoot = mpp.get(newNode.val);
        int numsLeft = inRoot - is;

        newNode.left = construct(preorder,ps + 1,ps + numsLeft,inorder,is,inRoot - 1,mpp);
        newNode.right = construct(preorder,ps + numsLeft + 1,pe,inorder,inRoot + 1,ie,mpp);

        return newNode;
    }
    public TreeNode bstFromPreorder(int[] preorder) {

         int[] inorder = Arrays.copyOf(preorder,preorder.length);

        Arrays.sort(inorder);

        Map<Integer,Integer> mpp = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){

            mpp.put(inorder[i],i);
        }

        return construct(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1,mpp);
        
    }
}
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
 class Pair{

    TreeNode node;
    boolean isParent;

    public Pair(TreeNode node,boolean isParent){

        this.node = node;
        this.isParent = isParent;
    }
 }
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        
        Map<Integer,Pair> mpp = new HashMap<>();

        TreeNode root = null;

        for(int[] description : descriptions){

            int parent = description[0];
            int child = description[1];
            int left = description[2];

            TreeNode parentNode;
            TreeNode childNode;

            if(mpp.containsKey(parent)){

                Pair pair = mpp.get(parent);

                parentNode = pair.node;


            }
            else{

                parentNode = new TreeNode(parent);
                
                mpp.put(parent,new Pair(parentNode,true));
            }

            
            if(mpp.containsKey(child)){

                Pair pair = mpp.get(child);

                childNode = pair.node;

                pair.isParent = false;
                
            }
            else{

                childNode = new TreeNode(child);

                mpp.put(child,new Pair(childNode,false));
            }

            if(left == 1){

                parentNode.left = childNode;
            }
            else{

                parentNode.right = childNode;
            }


        }

        for(Pair pair : mpp.values()){

            if(pair.isParent){

                return pair.node;
            }
        }



        return root;
    }
}
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

    private TreeNode node;
    private int level;

    public Pair(TreeNode node,int level){

        this.node = node;
        this.level = level;
    }

    public TreeNode getNode(){

        return node;
    }

    public int getLevel(){

        return level;
    }
 }

class Solution {
    public int maxLevelSum(TreeNode root) {
        
        Queue<Pair> q = new LinkedList<>();

        int level = 1;
        int sum = root.val;

        q.add(new Pair(root,level));

        while(!q.isEmpty()){

           
             int size = q.size();
            
            
            int currSum = 0;
             int currLevel = -1;
            

            for(int i = 0; i < size; i++){

                Pair peek = q.poll();
        

                currLevel = peek.getLevel();
                TreeNode node = peek.getNode();
                currSum += node.val;


                if(node.left != null){
                    
                    q.add(new Pair(node.left,currLevel+1));
                }
                if(node.right != null){

                     q.add(new Pair(node.right,currLevel+1));
                }
            }

          System.out.println(currSum);

            if(currSum > sum){

                sum = currSum;
                level = currLevel;

            }
            
        }

        return level;
    }
}
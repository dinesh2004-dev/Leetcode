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
    public TreeNode lca(TreeNode root,TreeNode p,TreeNode q){

        if(root == null || root == p || root == q){

            return root;
        }

        TreeNode left = lca(root.left,p,q);
        TreeNode right = lca(root.right,p,q);

        if(left == null){

            return right;
        }
        else if(right == null){

            return left;
        }

        return root;
    }
    public void findDepestNodes(TreeNode root,Map<TreeNode,Integer> mpp,int depth){

        if(root == null){

            return;
        }

        mpp.put(root,depth);

        findDepestNodes(root.left,mpp,depth + 1);
        findDepestNodes(root.right,mpp,depth + 1);

    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        
       Map<TreeNode,Integer> mpp = new HashMap<>();

       findDepestNodes(root,mpp,0);

       int maxDepth = Collections.max(mpp.values());
       
       List<TreeNode> maxDeepestNodes = new ArrayList<>();

       for(Map.Entry<TreeNode,Integer> set : mpp.entrySet()){

            TreeNode node = set.getKey();
            int val = set.getValue();

            if(val == maxDepth){

                maxDeepestNodes.add(node);
            }
       }

       if(maxDeepestNodes.size() == 1){

            return maxDeepestNodes.get(0);
       }

       TreeNode lcaNode = lca(root,maxDeepestNodes.get(0),maxDeepestNodes.get(1));
       for(int i = 2; i < maxDeepestNodes.size(); i++){

            lcaNode = lca(root,lcaNode,maxDeepestNodes.get(i));
       }

       return lcaNode;
    }
}
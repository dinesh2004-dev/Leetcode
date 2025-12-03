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
    class Tuple{

        TreeNode node;
        int row;
        int col;

        public Tuple(TreeNode node,int row,int col){

            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        Queue<Tuple> q = new LinkedList<>();

       TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> mpp = new TreeMap<>();

        q.add(new Tuple(root,0,0));

        while(!q.isEmpty()){

            Tuple tuple = q.poll();

            int c = tuple.col;
            int r = tuple.row;

            TreeNode node = tuple.node;

            if(!mpp.containsKey(c)){

                mpp.put(c,new TreeMap<>());
            }
            if(!mpp.get(c).containsKey(r)){

                mpp.get(c).put(r,new PriorityQueue<>());
            }


            mpp.get(c).get(r).add(node.val);

            if(node.left != null){

                q.add(new Tuple(node.left,tuple.row + 1,tuple.col - 1));
            }

            if(node.right != null){

                q.add(new Tuple(node.right,tuple.row + 1,tuple.col + 1));
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for(TreeMap<Integer,PriorityQueue<Integer>> ys : mpp.values()){

            res.add(new ArrayList<>());

            for(PriorityQueue<Integer> pq : ys.values()){

                while(!pq.isEmpty()){

                    res.get(res.size() - 1).add(pq.poll());
                }
            }
        }

        return res;

    }
}
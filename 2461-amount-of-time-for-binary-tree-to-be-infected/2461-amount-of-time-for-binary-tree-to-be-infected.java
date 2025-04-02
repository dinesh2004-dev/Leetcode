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
    public int amountOfTime(TreeNode root, int start) {
        // Your code goes here

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        TreeNode target = findParentMap(parentMap, root, start);

        int timeToBurn = findBurnTime(parentMap, target);

        return timeToBurn;
    }

    public TreeNode findParentMap(Map<TreeNode, TreeNode> parentMap, TreeNode root, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode res = null;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.val == start) {
                res = node;
            }

            if (node.left != null) {
                q.add(node.left);
                parentMap.put(node.left, node);
            }
            if (node.right != null) {
                q.add(node.right);
                parentMap.put(node.right, node);
            }
        }
        return res;
    }

    public int findBurnTime(Map<TreeNode, TreeNode> parentMap, TreeNode target) {
        Queue<TreeNode> q = new LinkedList<>();
        int timeToBurn = 0;
        Map<TreeNode, Boolean> visited = new HashMap<>();
        q.add(target);
        visited.put(target, true);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean burned = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.left != null && visited.get(node.left) == null) {
                    burned = true;
                    q.add(node.left);
                    visited.put(node.left, true);
                }
                if (node.right != null && visited.get(node.right) == null) {
                    burned = true;
                    q.add(node.right);
                    visited.put(node.right, true);
                }
                if (parentMap.get(node) != null && visited.get(parentMap.get(node)) == null) {
                    burned = true;
                    q.add(parentMap.get(node));
                    visited.put(parentMap.get(node), true);
                }
            }
            if (burned) {
                timeToBurn++;
            }
        }
        return timeToBurn;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Map to store parent of each node
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        populateParentMap(root, null, parentMap);

        // Queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);

        // Visited set to avoid cycles
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        int distance = 0;

        while (!queue.isEmpty()) {
            if (distance == k) {
                List<Integer> result = new ArrayList<>();
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                return result;
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // Process left child
                if (current.left != null && !visited.contains(current.left)) {
                    queue.offer(current.left);
                    visited.add(current.left);
                }

                // Process right child
                if (current.right != null && !visited.contains(current.right)) {
                    queue.offer(current.right);
                    visited.add(current.right);
                }

                // Process parent
                TreeNode parent = parentMap.get(current);
                if (parent != null && !visited.contains(parent)) {
                    queue.offer(parent);
                    visited.add(parent);
                }
            }
            distance++;
        }

        return new ArrayList<>(); // No nodes found at distance k
    }

    private void populateParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) {
            return;
        }
        parentMap.put(node, parent);
        populateParentMap(node.left, node, parentMap);
        populateParentMap(node.right, node, parentMap);
    }
}
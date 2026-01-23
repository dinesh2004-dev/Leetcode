import java.util.*;

class Node {
    long data; // Using long for safety
    Node next, prev;
    boolean dead = false;
    int id; // For leftmost selection

    public Node(long data, int id) {
        this.data = data;
        this.id = id;
    }
}

class Pair {
    long sum;
    Node left;

    public Pair(long sum, Node left) {
        this.sum = sum;
        this.left = left;
    }
}

class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        Node head = new Node(nums[0], 0);
        Node curr = head;
        int violations = 0;

        // Initialize DLL and initial violations
        for (int i = 1; i < n; i++) {
            Node newNode = new Node(nums[i], i);
            curr.next = newNode;
            newNode.prev = curr;
            if (curr.data > newNode.data) violations++;
            curr = newNode;
        }

        // PriorityQueue with tie-breaking for leftmost (node.id)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.sum != b.sum) return Long.compare(a.sum, b.sum);
            return Integer.compare(a.left.id, b.left.id);
        });

        // Fill PQ with initial pairs
        curr = head;
        while (curr != null && curr.next != null) {
            pq.add(new Pair(curr.data + curr.next.data, curr));
            curr = curr.next;
        }

        int ops = 0;
        while (violations > 0 && !pq.isEmpty()) {
            Pair top = pq.poll();
            Node L = top.left;
            Node R = L.next;

            // Validation for Lazy Deletion
            if (L.dead || R == null || R.dead || (L.data + R.data != top.sum)) continue;

            ops++;
            long newSum = L.data + R.data;

            // Remove old violations caused by L and R
            if (L.prev != null && L.prev.data > L.data) violations--;
            if (L.data > R.data) violations--;
            if (R.next != null && R.data > R.next.data) violations--;

            // Create new node to replace L and R
            Node newNode = new Node(newSum, L.id);
            Node p = L.prev;
            Node s = R.next;

            L.dead = true;
            R.dead = true;

            newNode.prev = p;
            newNode.next = s;

            if (p != null) p.next = newNode;
            else head = newNode; // Updating head if L was head
            
            if (s != null) s.prev = newNode;

            // Add new violations caused by newNode
            if (p != null && p.data > newNode.data) violations++;
            if (s != null && newNode.data > s.data) violations++;

            // Add new possible pairs to PQ
            if (p != null) pq.add(new Pair(p.data + newNode.data, p));
            if (s != null) pq.add(new Pair(newNode.data + s.data, newNode));
        }

        return ops;
    }
}
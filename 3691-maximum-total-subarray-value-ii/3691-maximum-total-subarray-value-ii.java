class Node{

    int i,j;
    long val;

    public Node(int i,int j,long val){

        this.i = i;
        this.j = j;
        this.val = val;
    }
}

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        
        int n = nums.length;

        SegmentTree st = new SegmentTree(nums);

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Long.compare(b.val,a.val));

        for(int i = 0; i < n; i++){

            int j = n - 1;

            int[] res = st.query(i,j);

            long val = res[1] - res[0];

            pq.add(new Node(i,j,val));
        }

        long ans = 0;

        while(k > 0){

            Node peek = pq.poll();

            ans += peek.val;

            int i = peek.i;
            int j = peek.j - 1;

            if(i <= j){

                int[] res = st.query(i,j);

                long val = res[1] - res[0];

                pq.add(new Node(i,j,val));
            }

            k--;
        }

        return ans;
    }
}

class SegmentTree{

    Node root;

    public SegmentTree(int[] nums){

        root = buildTree(nums,0,nums.length - 1);
    }

    private Node buildTree(int[] nums,int start,int end){
        
        Node node = new Node(start,end);

        if(start == end){

            node.max = nums[start];
            node.min = nums[start];

            return node;
        }

        int mid = (start + end) / 2;

        node.left = buildTree(nums,start,mid);
        node.right = buildTree(nums,mid + 1,end);

        node.min = Math.min(node.left.min,node.right.min);
        node.max = Math.max(node.left.max,node.right.max);

        return node;
    }

     public int[] query(int start, int end){
        return query(root, start, end);
    }   

    private int[] query(Node node,int start,int end){

        if(node == null){

            return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
        }

        if(start <= node.start && node.end <= end){

            return new int[]{node.min,node.max};
        }
        if(start > node.end || end < node.start){

            return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
        }

        int[] left = query(node.left,start,end);
        int[] right = query(node.right,start,end);

        int min = Math.min(left[0],right[0]);
        int max = Math.max(left[1],right[1]);

        return new int[]{min,max};
    }

    private class Node{
        int start, end;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Node left, right;

        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
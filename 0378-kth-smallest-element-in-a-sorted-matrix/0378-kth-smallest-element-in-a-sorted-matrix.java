class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int[] mat : matrix){

            for(int ele : mat){

                pq.add(ele);

                if(pq.size() > k){

                    pq.poll();
                }
            }
        }

        return pq.poll();
    }
}
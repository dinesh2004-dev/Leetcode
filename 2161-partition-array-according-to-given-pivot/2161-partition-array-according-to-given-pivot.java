class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        int n = nums.length;

        PriorityQueue<int[]> pq1 = new PriorityQueue<>((x,y) -> x[1] - y[1]);
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((x,y) -> x[1] - y[1]);

        for(int i = 0; i < n; i++){

            if(nums[i] > pivot){

                pq2.add(new int[]{nums[i],i});
            }
            else if(nums[i] < pivot){

                pq1.add(new int[]{nums[i],i});
            }
        }

        int pivots = n - (pq1.size() + pq2.size());

        int[] res = new int[n];

        int i = 0;

        while(!pq1.isEmpty()){

            res[i++] = pq1.poll()[0];
        }

        for(int j = 0; j < pivots; j++){

            res[i++] = pivot;
        }

        while(!pq2.isEmpty()){

            res[i++] = pq2.poll()[0];
        }

        return res;
    }
}
class Solution {
    public int maxTwoEvents(int[][] events) {
        
        Arrays.sort(events,(x,y) -> x[0] - y[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> x[0] - y[0]);

        int ans = 0;
        int maxVal = 0;

        for(int[] event : events){

            int start = event[0];
            int end = event[1];
            int value = event[2];

            while(!pq.isEmpty() && pq.peek()[0] < start){

                maxVal = Math.max(maxVal,pq.peek()[1]);
                pq.poll();
            }

            ans = Math.max(ans,maxVal + value);

            pq.add(new int[]{end,value});
        }

        return ans;
    }
}
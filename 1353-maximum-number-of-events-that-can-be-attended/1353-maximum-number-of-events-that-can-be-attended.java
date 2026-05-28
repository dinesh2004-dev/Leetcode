class Solution {
    public int maxEvents(int[][] events) {
        
        int maxDay = events[0][1];

        for(int[] event : events){

            maxDay = Math.max(maxDay,event[1]);
        }

        int n = events.length;

        Arrays.sort(events,(x,y) -> x[0] - y[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int ans = 0;

        for(int i = 0,j = 0; i <= maxDay; i++){

            while(j < n && events[j][0] <= i){

                pq.add(events[j][1]);
                j++;
            }

            while(!pq.isEmpty() && pq.peek() < i){

                pq.poll();
            }

            if(!pq.isEmpty()){

                pq.poll();

                ans++;
            }
        }

        return ans;
    }
}
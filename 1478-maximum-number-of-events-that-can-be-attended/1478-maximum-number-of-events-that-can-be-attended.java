class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events,(x,y) -> x[0] - y[0]);
        int day = 0,index = 0,count = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(!pq.isEmpty() || index < n){
            if(pq.isEmpty()){
                day = events[index][0];
            }
            while(index < n && events[index][0] <= day){
                pq.add(events[index][1]);
                index++;
            }
            pq.poll();
            count++;
            day++;
            while(!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }
        }
        return count;
    }
}
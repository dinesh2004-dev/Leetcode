class Solution {
    public int scheduleCourse(int[][] courses) {
        
        int n = courses.length;

        Arrays.sort(courses,(x,y) -> x[1] - y[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>
                                        ((x,y) -> y - x);
        
        int total = 0;

        for(int i = 0; i < n; i++){

            int duration = courses[i][0],lastDay = courses[i][1];

            total += duration;

            pq.add(duration);

            if(total > courses[i][1]){

                total -= pq.poll();
            }
        }

        return pq.size();
    }
}
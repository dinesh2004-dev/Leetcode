class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        int n = intervals.length;
        
        Arrays.sort(intervals,(x,y) -> {
            return x[1] - y[1];
        });

        int lastEnd = intervals[0][1];

        int cnt = 0;

        for(int i = 1; i < n; i++){

            if(lastEnd > intervals[i][0]){

                cnt++;
            }
            else{

                lastEnd = intervals[i][1];
            }

            
        }

        return cnt;
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(x,y) -> x[0] - y[0]);
        ArrayList<int[]> res = new ArrayList<>();
        int[] prev = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            int[] interval = intervals[i];
            if(interval[0] <= prev[1]){
                prev[1] = Math.max(interval[1],prev[1]);
            }
            else{
                res.add(prev);
                prev = interval;
            }
        }
        res.add(prev);
        return res.toArray(new int[0][]);
    }
}
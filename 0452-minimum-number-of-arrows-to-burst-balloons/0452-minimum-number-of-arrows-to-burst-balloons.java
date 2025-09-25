class Solution {
    public int findMinArrowShots(int[][] points) {
        
        int n = points.length;

        Arrays.sort(points,(x,y) -> Integer.compare(x[1],y[1]));

        int arrow = points[0][1];
        int cnt = 1;
        
        for(int i = 1; i < n; i++){
        
            if(arrow < points[i][0]){

                cnt++;
                arrow = points[i][1];
            }
        }
        return cnt;
    }
}
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        
        int n = points.length;
        int minSeconds = 0;

        for(int i = 0; i < n - 1; i++){

            int[] point1 = points[i];
            int[] point2 = points[i + 1];

            int sec = Math.max(Math.abs(point1[0] - point2[0]),
                            Math.abs(point1[1] - point2[1]));
            
            minSeconds += sec;
        }

        return minSeconds;
    }
}
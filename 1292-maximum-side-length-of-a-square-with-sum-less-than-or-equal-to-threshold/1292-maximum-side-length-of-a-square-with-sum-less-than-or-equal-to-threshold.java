class Solution {
    private boolean isUnderThreshold(int[][] mat,int[][] rowSum,int r1,int c1,
     int r2,int c2,int threshold){

        int sum = 0;

        for(int i = r1; i <= r2; i++){

            sum += rowSum[i][c2 + 1] - rowSum[i][c1];
        }

        return sum <= threshold;
     }
     public boolean existsSquare(int[][] mat, int[][] rowSum, int k, int threshold){

        int m = mat.length;
        int n = mat[0].length;

        for(int i = 0; i + k - 1 < m; i++){

                for(int j = 0; j + k - 1 < n; j++){

                    if(isUnderThreshold(mat,rowSum,i,j,i+k-1,j+k-1,threshold)){

                        return true;
                    }
                }
            }

            return false;

     }
    public int maxSideLength(int[][] mat, int threshold) {
        
        int m = mat.length;
        int n = mat[0].length;

        int[][] rowSum = new int[m][n + 1];

        for(int i = 0; i < m; i++){

            for(int j = 1; j <= n; j++){

                rowSum[i][j] = rowSum[i][j - 1] + mat[i][j - 1];
            }
        }

        int ans = 0;

        int low = 0,high = Math.min(m,n);

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(existsSquare(mat,rowSum,mid,threshold)){

                low = mid + 1;
            }
            else{

                high = mid - 1;
            }
        }

        return high;
    }
}
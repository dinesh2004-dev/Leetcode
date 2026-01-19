class Solution {
    private boolean isUnderThreshold(int[][] mat,int[][] rowSum,int r1,int c1,
     int r2,int c2,int threshold){

        int sum = 0;

        for(int i = r1; i <= r2; i++){

            sum += rowSum[i][c2 + 1] - rowSum[i][c1];
        }

        return sum <= threshold;
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

        for(int k = 1; k <= Math.min(m,n); k++){

            for(int i = 0; i + k - 1 < m; i++){

                for(int j = 0; j + k - 1 < n; j++){

                    if(isUnderThreshold(mat,rowSum,i,j,i+k-1,j+k-1,threshold)){

                        ans = Math.max(ans,k);
                    }
                }
            }
        }

        return ans;
    }
}
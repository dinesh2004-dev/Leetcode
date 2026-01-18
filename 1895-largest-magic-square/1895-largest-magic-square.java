class Solution {
    public boolean isMagicSquare(int[][] grid,int[][] prefix,int r1,
    int c1,int r2,int c2){

        int totalSum = prefix[r2 + 1][c2 + 1] -
                       prefix[r1][c2 + 1] - 
                       prefix[r2 + 1][c1] +
                       prefix[r1][c1];
        
    int k = r2 - r1 + 1;

    if (totalSum % k != 0) return false;   

    int expectedSum = totalSum / k;   
        
        for(int i = r1; i <= r2; i++){

            int rowSum = prefix[i + 1][c2 + 1] - 
                         prefix[i][c2 + 1] - 
                         prefix[i + 1][c1] +
                         prefix[i][c1];
            if(rowSum != expectedSum){

                return false;
            }
        }

        for(int i = c1; i <= c2; i++){

            int colSum = prefix[r2 + 1][i + 1] -
                         prefix[r1][i + 1] -
                         prefix[r2 + 1][i] +
                         prefix[r1][i];
            
            if(colSum != expectedSum){

                return false;
            }
        }

       

        int majorDiagonalSum = 0;
        for (int i = r1, j = c1; i <= r2; i++, j++) {

            majorDiagonalSum += grid[i][j];

        }

        int minorDiagonalSum = 0;
        for (int i = r1, j = c2; i <= r2; i++, j--) {

            minorDiagonalSum += grid[i][j];

        }

        return majorDiagonalSum == expectedSum && minorDiagonalSum == expectedSum;


    }
    public int largestMagicSquare(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int[][] prefix = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++){

            for(int j = 1; j <= n; j++){

                prefix[i][j] = grid[i - 1][j - 1] +
                                  prefix[i - 1][j] + 
                                  prefix[i][j - 1] - 
                                  prefix[i - 1][j - 1];

            }
        }

        int mini = Math.min(m,n);
        int ans = 1;

        for(int k = 1; k <= mini; k++){

            for(int i = 0; i + k - 1 < m; i++){

                for(int j = 0; j + k - 1 < n; j++){

                    if(isMagicSquare(grid,prefix,i,j,i + k - 1,
                    j + k - 1)){

                        ans = Math.max(k,ans);
                    }
                }
            }
        }

        return ans;
    }
}
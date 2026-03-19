class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        
      int m = grid.length;
      int n = grid[0].length;

      int xCount = 0;
      int cnt = 0;

      int[][] prefix = new int[m][n];
      int[][] xPrefix = new int[m][n];

      for(int i = 0; i < m; i++){

        for(int j = 0; j < n; j++){

           if(grid[i][j] == 'X'){

                prefix[i][j] = 1;
                xPrefix[i][j] = 1;
                
           }
           else if(grid[i][j] == 'Y'){

                prefix[i][j] = -1;
                // yCount++;
           }
           else{

                prefix[i][j] = 0;
           }

           if(i > 0){

                prefix[i][j] = prefix[i][j] + prefix[i - 1][j];
                xPrefix[i][j] = xPrefix[i][j] + xPrefix[i - 1][j];
           }
           if(j > 0){

                prefix[i][j] = prefix[i][j] + prefix[i][j - 1];
                xPrefix[i][j] = xPrefix[i][j] + xPrefix[i][j - 1];
           }

           if(i > 0 && j > 0){

                prefix[i][j] = prefix[i][j] - prefix[i - 1][j - 1];
                xPrefix[i][j] = xPrefix[i][j] - xPrefix[i - 1][j - 1];
               
           }

           if(prefix[i][j] == 0 && xPrefix[i][j] >= 1){

                cnt++;
           }
        }
      }

      return cnt;
    }
}
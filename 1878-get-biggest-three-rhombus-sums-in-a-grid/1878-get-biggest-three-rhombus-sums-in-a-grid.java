class Solution {
      private static int findBorderSum(int[][] mat,int r,int c,int k){

    if(k == 0) return mat[r][c];

    int sum = 0;

    // top -> right
    for(int i = 0; i < k; i++)
        sum += mat[r - k + i][c + i];

    // right -> bottom
    for(int i = 0; i < k; i++)
        sum += mat[r + i][c + k - i];

    // bottom -> left
    for(int i = 0; i < k; i++)
        sum += mat[r + k - i][c - i];

    // left -> top
    for(int i = 0; i < k; i++)
        sum += mat[r - i][c - k + i];

    return sum;
}
    public int[] getBiggestThree(int[][] grid) {
        
        int m = grid.length;
	   int n = grid[0].length;

       int[][] diag1 = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                diag1[i][j] = grid[i-1][j-1] + diag1[i-1][j-1];
            }
        }

        int[][] diag2 = new int[m+1][n+2];

        for(int i = 1; i <= m; i++){
            for(int j = n; j >= 1; j--){
                diag2[i][j] = grid[i-1][j-1] + diag2[i-1][j+1];
            }
        }
	   
	

      TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

    for(int r = 0; r < m; r++){

        for(int c = 0; c < n; c++){

            int maxSize = Math.min(Math.min(r, m-1-r),
                               Math.min(c, n-1-c));

            for(int k = 0; k <= maxSize; k++){

                 if(k == 0){
                    set.add(grid[r][c]);
                    continue;
                }

                  int topRow = r-k;
                    int bottomRow = r+k;
                    int leftCol = c-k;
                    int rightCol = c+k;

                    int sum = 0;

                    // top -> right
                    sum += diag1[r+1][rightCol+1] - diag1[topRow][c];

                    // right -> bottom
                    sum += diag2[bottomRow+1][c+1] - diag2[r][rightCol+2];

                    // bottom -> left
                    sum += diag1[bottomRow+1][c+1] - diag1[r][leftCol];

                    // left -> top
                    sum += diag2[r+1][leftCol+1] - diag2[topRow][c+2];

                    // remove corner duplicates
                    sum -= grid[topRow][c];
                    sum -= grid[r][rightCol];
                    sum -= grid[bottomRow][c];
                    sum -= grid[r][leftCol];

                    set.add(sum);
            }
    } 
    }

    int size = Math.min(3, set.size());
        int[] res = new int[size];

        int i = 0;
        for(int val : set){
            if(i == 3) break;
            res[i++] = val;
        }

        return res;
}
}
    

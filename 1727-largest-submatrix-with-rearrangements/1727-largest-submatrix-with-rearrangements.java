class Solution {
    public int largestSubmatrix(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        for(int c = 0; c < n; c++){

            for(int r = 1; r < m; r++){

               if(matrix[r][c] != 0){

                     matrix[r][c] = matrix[r][c] + matrix[r - 1][c];
               }
            }
        }

        int maxArea = 0;

        for(int[] mat : matrix){

            Arrays.sort(mat);

            for(int j = 0; j < n; j++){

                maxArea = Math.max(maxArea,mat[j] * (n - j));
            }
        }

        return maxArea;
    }
}
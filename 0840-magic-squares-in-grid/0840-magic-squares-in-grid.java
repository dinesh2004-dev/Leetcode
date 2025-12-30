class Solution {
    public boolean isMagic(int[][] grid,int row,int col){

        boolean[] seen = new boolean[10];

        for(int i = row; i < row + 3; i++){

            for(int j = col; j < col + 3; j++){

                int val = grid[i][j];

                if(val < 1 || val > 9 || seen[val]){

                    return false;
                }

                seen[val] = true;
            }
        }

            if(grid[row + 1][col + 1] != 5){

                return false;
            }

            int sum = 15;

            for(int i = row; i < row + 3; i++){

                int rowSum = 0;

                for(int j = col; j < col + 3; j++){

                    rowSum += grid[i][j];
                }

                if(rowSum != sum){

                    return false;
                }
            }

            for(int j = col; j < col + 3; j++){

                int colSum = 0;

                for(int i = row; i < row + 3; i++){

                    colSum += grid[i][j];
                }

                if(colSum != sum){

                    return false;
                }
            }

            int diag1 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
            int diag2 = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];

             return diag1 == sum && diag2 == sum;
        }
    
    public int numMagicSquaresInside(int[][] grid) {
        
        int count = 0;

        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i <= m - 3; i++){

            for(int j = 0; j <= n - 3; j++){

                if(isMagic(grid,i,j)){

                    count++;
                }
            }
        }

        return count;
    }
}
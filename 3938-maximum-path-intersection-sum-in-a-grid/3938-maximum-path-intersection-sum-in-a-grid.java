class Solution {
    public int maxScore(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int res = (int) -1e9;

        for(int i = 1; i < n - 1; i++){

            for(int j = 1; j < m - 1; j++){

                res = Math.max(res,grid[i][j]);
            }
        }

        for(int i = 0; i < n; i++){

            int max = (int) -1e9,sum = grid[i][0];

            for(int j = 1; j < m; j++){

                max = Math.max(max,sum + grid[i][j]);
                sum = Math.max(grid[i][j],sum + grid[i][j]);
            }

            res = Math.max(max,res);
        }

         for(int j = 0; j < m; j++){

            int max = (int) -1e9,sum = grid[0][j];

            for(int i = 1; i < n; i++){

                max = Math.max(max,sum + grid[i][j]);
                sum = Math.max(grid[i][j],sum + grid[i][j]);
            }

            res = Math.max(max,res);
        }

        return res;
    }
}
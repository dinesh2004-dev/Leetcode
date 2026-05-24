class Solution {
   private static int m,n;
    private int solve(int[][] grid,int r1,int c1,int r2,int c2,int[][][][] dp){

        if(r1 >= m || c1 >= n || r2 >= m || c2>= n || grid[r1][c1] == -1 || 
            grid[r2][c2] == -1){

                return Integer.MIN_VALUE;
            }
        
        if(r1 == m - 1 && c1 == n - 1){

            return grid[r1][c1];
        }

        if(r2 == m - 1 && c2 == n - 1){

            return grid[r2][c2];
        }

         if(dp[r1][c1][r2][c2] != -1){

            return dp[r1][c1][r2][c2];
        }

        int cherries = 0;

        if(r1 == r2 && c1 == c2){

            cherries += grid[r1][c1];
        }
        else{

            cherries += grid[r1][c1] + grid[r2][c2];
        }

        int down = solve(grid,r1 + 1,c1,r2 + 1,c2,dp);
        int downRight = solve(grid,r1 + 1,c1,r2,c2 + 1,dp);
        int rightDown = solve(grid,r1,c1 + 1,r2 + 1,c2,dp);
        int right = solve(grid,r1,c1 + 1,r2,c2 + 1,dp);

        cherries += Math.max(Math.max(down,downRight),Math.max(rightDown,right));

        return dp[r1][c1][r2][c2] = cherries;
    }
    public int cherryPickup(int[][] grid) {
        
        m = grid.length;
        n = grid[0].length;

        int[][][][] dp = new int[m][n][m][n];

        for(int[][][] d1 : dp){

            for(int[][] d2 : d1){

                for(int[] d3 : d2){

                    Arrays.fill(d3,-1);
                }
            }

        }

        int res = solve(grid,0,0,0,0,dp);

        return Math.max(0,res);
    }
}
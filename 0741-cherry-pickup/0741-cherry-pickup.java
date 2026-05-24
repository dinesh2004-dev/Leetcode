class Solution {
   private static int m,n;
    private int solve(int[][] grid,int t,int r1,int r2,int[][][] dp){

        int c1 = t - r1;
        int c2 = t - r2;

        if(r1 >= m || c1 >= n || r2 >= m || c2 >= n || grid[r1][c1] == -1 || 
            grid[r2][c2] == -1){

                return Integer.MIN_VALUE;
            }
        
        if(r1 == m - 1 && c1 == n - 1){

            return grid[r1][c1];
        }

        if(r2 == m - 1 && c2 == n - 1){

            return grid[r2][c2];
        }

         if(dp[t][r1][r2] != -1){

            return dp[t][r1][r2];
        }

        int cherries = 0;

        if(r1 == r2 && c1 == c2){

            cherries += grid[r1][c1];
        }
        else{

            cherries += grid[r1][c1] + grid[r2][c2];
        }

        int down = solve(grid,t + 1,r1 + 1,r2 + 1,dp);
        int downRight = solve(grid,t + 1,r1 + 1,r2,dp);
        int rightDown = solve(grid,t + 1,r1,r2 + 1,dp);
        int right = solve(grid,t + 1,r1,r2,dp);

        cherries += Math.max(Math.max(down,downRight),Math.max(rightDown,right));

        return dp[t][r1][r2] = cherries;
    }
    public int cherryPickup(int[][] grid) {
        
        m = grid.length;
        n = grid[0].length;

        System.out.println(m +" "+n);

        int[][][] dp = new int[2 * n - 1][m][m];

        for(int[][] d1 : dp){

            for(int[] d2 : d1){

                Arrays.fill(d2,-1);
                
            }

        }

        int res = solve(grid,0,0,0,dp);

        return Math.max(0,res);
    }
}
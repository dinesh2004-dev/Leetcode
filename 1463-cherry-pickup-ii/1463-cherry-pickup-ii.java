class Solution {
    private int solve(int[][] grid,int i,int j1,int j2,int[][][] dp){

        if(j1 < 0 || j2 < 0 || j1 >= grid[0].length || j2 >= grid[0].length){

            return (int) -1e9;
        }

        if(i == grid.length - 1){

            if(j1 == j2){

                return grid[i][j1];
            }

            return grid[i][j1] + grid[i][j2];
        }

        if(dp[i][j1][j2] != -1){

            return dp[i][j1][j2];
        }

        int maxi = (int) -1e9;

        for(int d1 = -1; d1 <= 1; d1++){

            for(int d2 = -1; d2 <= 1; d2++){

                int ans;

                if(j1 == j2){

                    ans = grid[i][j1] + solve(grid,i + 1,j1 + d1,j2 + d2,dp);
                }
                else{

                    ans = grid[i][j1] + grid[i][j2] + solve(grid,i + 1,j1 + d1,j2 + d2,dp);
                }

                maxi = Math.max(maxi,ans);
            }
        }

        return dp[i][j1][j2] = maxi;
    }
    public int cherryPickup(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];

        for(int[][] d1 : dp){

            for(int[] d2 : d1){

                Arrays.fill(d2,-1);
            }
        }
        
        return solve(grid,0,0,n - 1,dp);
    }
}
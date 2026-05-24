class Solution {
    
    int minSum = Integer.MAX_VALUE;
    

    private int solve(int[][] grid,int row,int col,int[][] dp){

        if(row == grid.length - 1 && col == grid[0].length - 1){

            return grid[row][col];
        }
      
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){

            return Integer.MAX_VALUE;
        }

        if(dp[row][col] != -1){

            return dp[row][col];
        }

        int down = solve(grid,row + 1,col,dp);
        int right = solve(grid,row,col + 1,dp);

        return dp[row][col] = grid[row][col] + Math.min(down,right);

       

       
    }
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int[] d : dp){

            Arrays.fill(d,-1);
        }
        
        return solve(grid,0,0,dp);

        
    }
}
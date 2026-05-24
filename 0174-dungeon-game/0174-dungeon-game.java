class Solution {
    private int solve(int[][] dugeon,int row,int col,int[][] dp){

        if(row == dugeon.length || col == dugeon[0].length){

            return (int) 1e9;
        }

        if(row == dugeon.length - 1 && col == dugeon[0].length - 1){

            if(dugeon[row][col] > 0){

                return 1;
            }
            else{

                return Math.abs(dugeon[row][col]) + 1;
            }
        }

        if(dp[row][col] != -1){

            return dp[row][col];
        }

        int down = solve(dugeon,row + 1,col,dp);
        int right = solve(dugeon,row,col + 1,dp);

        int res = Math.min(down,right) - dugeon[row][col];

        return dp[row][col] = Math.max(res,1);

    }
    public int calculateMinimumHP(int[][] dungeon) {
        
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[201][201];

        for(int[] d : dp){

            Arrays.fill(d,-1);
        }

        return solve(dungeon,0,0,dp);
    }
}
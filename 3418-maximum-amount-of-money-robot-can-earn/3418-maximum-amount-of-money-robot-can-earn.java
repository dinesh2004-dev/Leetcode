class Solution {
    private int solve(int[][] coins,int r,int c,int k,int[][][] dp){

        if(r == coins.length - 1 && c == coins[0].length - 1){

            if(coins[r][c] < 0 && k > 0){

                return 0;
            }

            return coins[r][c];        
        }
       

        if(dp[r][c][k] != (int) 1e9){

            return dp[r][c][k];
        }

        

        int bottom = (int) -1e9,right = (int) -1e9;

        if(r + 1 < coins.length){

            bottom = coins[r][c] + solve(coins,r + 1,c,k,dp);

            if(coins[r][c] < 0 && k > 0){

                bottom = Math.max(bottom,solve(coins,r + 1,c,k - 1,dp));
            }
        }

        if(c + 1 < coins[0].length){

            right = coins[r][c] + solve(coins,r,c + 1,k,dp);

            if(coins[r][c] < 0 && k > 0){

                right = Math.max(right,solve(coins,r,c + 1,k - 1,dp));
            }
        }

       
        return dp[r][c][k] = Math.max(bottom,right);

        

    }
    public int maximumAmount(int[][] coins) {

        int m = coins.length;
        int n = coins[0].length;
        int k = 3;

        int[][][] dp = new int[m][n][k];

        for(int[][] dp1 : dp){

            for(int[] dp2 : dp1){

                Arrays.fill(dp2,(int) 1e9);
            }
        }
        return solve(coins,0,0,2,dp);
    }
}
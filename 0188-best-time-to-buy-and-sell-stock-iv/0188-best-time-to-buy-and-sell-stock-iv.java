class Solution {
    private int solve(int[] prices,int ind,int canBuy,int k,int[][][] dp){

        if(ind >= prices.length || k <= 0){

            return 0;
        }

        if(dp[ind][canBuy][k] != -1){

            return dp[ind][canBuy][k];
        }

        int profit = 0;

        if(canBuy == 0){

            profit += Math.max( (-1) * prices[ind] + solve(prices,ind + 1,1,k,dp),solve(prices,ind + 1,canBuy,k,dp));
        }
        else{

            profit += Math.max(prices[ind] + solve(prices,ind + 1,0,k - 1,dp),
            solve(prices,ind + 1,canBuy,k,dp));
        }

        return dp[ind][canBuy][k] = profit;
    }
    public int maxProfit(int k, int[] prices) {

        int n = prices.length;

        int[][][] dp = new int[n][2][k + 1];

        for(int[][] d1 : dp){

            for(int[] d2 : d1){

                Arrays.fill(d2,-1);
            }
        }
        
        return solve(prices,0,0,k,dp);
    }
}
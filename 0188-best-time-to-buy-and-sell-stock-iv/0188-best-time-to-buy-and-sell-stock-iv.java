class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
         int[][][] dp = new int[n + 1][2][k + 1];

        int profit = 0;

        for(int i = n - 1; i >= 0; i--){

            for(int buy = 0; buy <= 1; buy++){

                for(int cap = 1; cap <= k; cap++){

                    if(buy == 0){

                        profit = Math.max(0 + dp[i + 1][0][cap],(-1) * prices[i] + dp[i + 1][1][cap]);
                    }
                    else{
                        profit = Math.max(0 + dp[i + 1][1][cap],prices[i] + dp[i + 1][0][cap - 1]);
                    }

                     dp[i][buy][cap] = profit;
                }

               
            }
        }

        return dp[0][0][k];
    }
}
class Solution {

    private static int mod = (int) 1e9 + 7;
    private int solve(int ind,int n,int minProfit,int currProfit,int[] group,int[] profit,int[][][] dp){

        if(ind == group.length){

            return currProfit >= minProfit ? 1 : 0;
        }
        
        if(dp[ind][n][currProfit] != -1){

            return dp[ind][n][currProfit];
        }

        int notPick = solve(ind + 1,n,minProfit,currProfit,group,profit,dp);

        int pick = 0;

        if(n >= group[ind]){

            pick = solve(ind + 1,n - group[ind],minProfit,currProfit + profit[ind],
                        group,profit,dp);
        }

        return dp[ind][n][currProfit] = (pick + notPick) % mod;
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {

        // int len = group.length;

        // int profitSum = Arrays.stream(profit).sum();

        // int[][][] dp = new int[len][n + 1][profitSum + 1];

        // for(int[][] d1 : dp){
        //     for(int[] d2 : d1){

        //         Arrays.fill(d2,-1);
        //     }
        // }

        // return solve(0,n,minProfit,0,group,profit,dp);

        int len = group.length;

        int profitSum = Arrays.stream(profit).sum();

        int[][][] dp = new int[len  + 1][n + 1][profitSum + 1];

       for(int j = 0; j <= n; j++){

        for(int k = minProfit; k <= profitSum; k++){

            dp[len][j][k] = 1;
          }
       }

       for(int ind = len - 1; ind >= 0; ind--){

            for(int j = 0; j <= n; j++){

                for(int currProfit = 0; currProfit <= profitSum; currProfit++){

                    int notPick =dp[ind + 1][j][currProfit];

                    int pick = 0;

                    if(j >= group[ind]){

                         int newProfit = Math.min(currProfit + profit[ind], profitSum);
                        pick = dp[ind + 1][j - group[ind]][newProfit];
                    }

                    dp[ind][j][currProfit] = (pick + notPick) % 1000000007;
                }
            }
       }

       return dp[0][n][0];


        
    }
}
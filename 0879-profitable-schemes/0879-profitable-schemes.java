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

        int len = group.length;

        int profitSum = Arrays.stream(profit).sum();

        int[][][] dp = new int[len][n + 1][profitSum + 1];

        for(int[][] d1 : dp){
            for(int[] d2 : d1){

                Arrays.fill(d2,-1);
            }
        }

        return solve(0,n,minProfit,0,group,profit,dp);
        
    }
}
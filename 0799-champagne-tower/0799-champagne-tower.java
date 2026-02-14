class Solution {
    private double solve(int poured,int query_row,int query_glass,Double[][] dp){

        if(query_row < 0 || query_glass < 0 || query_glass > query_row){

            return 0.0;
        }

        if(query_row == 0 && query_glass == 0){

            return (double) poured;
        }

        if(dp[query_row][query_glass] != null){

            return dp[query_row][query_glass];
        }

        double left = Math.max(0,(solve(poured,query_row - 1,query_glass - 1,dp) - 1) * 0.5);
         double right = Math.max(0,(solve(poured,query_row - 1,query_glass,dp) - 1) * 0.5);

        double ans = left + right;

        return dp[query_row][query_glass] = ans;
    }
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        Double[][] dp = new Double[101][101];

        return Math.min(1.0, solve(poured,query_row,query_glass,dp));
    }
}
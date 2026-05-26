class Solution {
    private int solve(int[] values,int i,int j,int[][] dp){

        if(i >= j){

            return 0;
        }

        if(dp[i][j] != -1){

            return dp[i][j];
        }

        int res = (int) 1e9;

        for(int k = i; k <= j - 1; k++){

            int triangulate = values[i - 1] * values[k] * values[j] 
                                + solve(values,i,k,dp) + solve(values,k + 1,j,dp);
            
            res = Math.min(triangulate,res);
        }

        return dp[i][j] = res;
    }
    public int minScoreTriangulation(int[] values) {
        
        int n = values.length;

        int[][] dp = new int[n][n];

        for(int[] d : dp){

            Arrays.fill(d,-1);
        }

        return solve(values,1,n - 1,dp);
    }
}
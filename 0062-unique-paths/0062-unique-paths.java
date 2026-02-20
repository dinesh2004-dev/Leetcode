class Solution {
    
    public int uniquePaths(int m, int n) {
        
        int dp[][] = new int[m+1][n+1];

        for(int i = m; i > 0; i--){

            for(int j = n; j > 0; j--){

                if(i == m && j == n){

                    dp[i][j] = 1;

                    continue;
                }

                int down = 0,right = 0;

                if(i + 1 <= m){

                    down = dp[i + 1][j];
                }
                if(j + 1 <= n){

                    right = dp[i][j + 1];
                }

                dp[i][j] = down + right;
            }
        }

        return dp[1][1];
    }
}
class Solution {
    public int cherryPickup(int[][] matrix) {
         int m = matrix.length;

        int n = matrix[0].length;

        int[][][] dp = new int[m][n][n];

        

        for(int j1 = 0; j1 < n; j1++){

            for(int j2 = 0; j2 < n; j2++){

                if(j1 == j2){

                    dp[m - 1][j1][j2] = matrix[m - 1][j1];
                }
                else{

                    dp[m- 1][j1][j2] = matrix[m - 1][j1] + matrix[m - 1][j2];
                }
            }
        }

            for(int i = m -  2; i >= 0; i--){

                for(int j1 = 0; j1 < n; j1++){

                    for(int j2 = 0; j2 < n; j2++){

                        int maxi = Integer.MIN_VALUE;
                        for(int di = -1; di <= 1; di++){

                            for(int dj = -1; dj <= 1; dj++){
                                int ans = 0;
                                if(j1 == j2){

                                    ans = matrix[i][j1];
                                }
                                else{
                                    ans = matrix[i][j1] + matrix[i][j2];
                                }

                                if((j1 + di < 0 || j1 + di >= n) || (j2 + dj < 0 || j2 + dj >= n)){
                                    ans += -1e9;
                                }
                                else{
                                    ans += dp[i + 1][j1 + di][j2 + dj];
                                }

                                maxi = Math.max(ans,maxi);
                            }
                        }

                        dp[i][j1][j2] = maxi;
                    }

                }
            }

            return dp[0][0][n - 1];
    }
}
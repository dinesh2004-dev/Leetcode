class Solution {
    public int minDistance(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();

       

        if(n == 0 || m == 0){

            return m == 0 ? n : m;
        }

        int[][] dp = new int[n + 1][m + 1];

       for(int i = 0; i <= m; i++){
            dp[n][i] = m - i;   // chars remaining in word2
        }

        for(int i = 0; i <= n; i++){
            dp[i][m] = n - i;   // chars remaining in word1
        }

        dp[n][m] = 0;

        for(int ind1 = n - 1;ind1 >= 0; ind1--){

            for(int ind2 = m - 1; ind2 >= 0; ind2--){

                if(word1.charAt(ind1) == word2.charAt(ind2)){

                    dp[ind1][ind2] = dp[ind1 + 1][ind2 + 1];
                }
                else{

                    dp[ind1][ind2] = Math.min(1 + dp[ind1][ind2 + 1],
                                              Math.min(1 + dp[ind1 + 1][ind2],
                                              1 + dp[ind1 + 1][ind2 + 1]));
                }
            }
        }

        return dp[0][0];
    }
}
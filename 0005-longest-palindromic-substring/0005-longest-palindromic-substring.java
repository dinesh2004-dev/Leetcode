class Solution {
    public boolean solve(String s,int i,int j,boolean[][] dp){

        if( i >= j){

            return true;
        }

        if(dp[i][j]){

            return dp[i][j];
        }

        if(s.charAt(i) == s.charAt(j)){

            return dp[i][j] = solve(s,i + 1,j - 1,dp);
        }

        return dp[i][j] = false;

    }
    public String longestPalindrome(String s) {

        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        int startIdx = 0;
        int maxLen = 1;

        for(int i = 0; i < n; i++){

            for(int j = i; j < n; j++){

                if(j - i + 1  > maxLen && solve(s,i,j,dp)){

                    startIdx = i;
                   maxLen = j - i + 1;
                }
            }
        }

        return s.substring(startIdx,startIdx + maxLen);
        
    }
}
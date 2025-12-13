class Solution {
    public boolean solve(String s,int l,int h,boolean[][] dp){

        if(l >= h){

            return true;
        }

        if(dp[l][h]){

            return dp[l][h];
        }

        if(s.charAt(l) == s.charAt(h)){

            return dp[l][h] = solve(s,l + 1,h - 1,dp);
        }

        return dp[l][h] = false;
    }
    public int countSubstrings(String s) {

        int n = s.length();

        int count = 0;

        boolean[][] dp = new boolean[n][n];

        for(int i = 0; i < n; i++){

            for(int j = i; j < n; j++){

                if(solve(s,i,j,dp)){

                    count++;
                }
            }
        }

        return count;
        
    }
}
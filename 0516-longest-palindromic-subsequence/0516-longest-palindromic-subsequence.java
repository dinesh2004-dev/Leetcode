class Solution {
    public int solve(int ind1,int ind2,String str1,String str2,int[][] dp){

        if(ind1 < 0 || ind2 < 0){

            return 0;
        }

        if(dp[ind1][ind2] != -1){

            return dp[ind1][ind2];
        }

        if(str1.charAt(ind1) == str2.charAt(ind2)){

            return dp[ind1][ind2] = 1 + solve(ind1 - 1,ind2 - 1,str1,str2,dp);
        }

        return dp[ind1][ind2] = Math.max(solve(ind1 - 1,ind2,str1,str2,dp),
                        solve(ind1,ind2 - 1,str1,str2,dp));
    }
    public int longestPalindromeSubseq(String s) {

        int n = s.length();

        String rev  = new StringBuilder(s).reverse().toString();

        int[][] dp = new int[n][n];

        for(int[] d : dp){

            Arrays.fill(d,-1);
        }

        return solve(n - 1,n - 1,s,rev,dp);
        
    }
}
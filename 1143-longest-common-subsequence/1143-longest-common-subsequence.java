class Solution {
    private int solve(int ind1,int ind2,String text1,String text2,int[][] dp){

        if(ind1 == text1.length() || ind2 == text2.length()){

            return 0;
        }

        if(dp[ind1][ind2] != -1){

            return dp[ind1][ind2];
        }

        if(text1.charAt(ind1) == text2.charAt(ind2)){

            return dp[ind1][ind2] = 1 + solve(ind1 + 1,ind2 + 1,text1,text2,dp);
        }
        else{

            return dp[ind1][ind2] = Math.max(solve(ind1 + 1,ind2,text1,text2,dp),
                            solve(ind1,ind2 + 1,text1,text2,dp));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {

        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1][n2];

        for(int[] d : dp){

            Arrays.fill(d,-1);
        }
        
        return solve(0,0,text1,text2,dp);
    }
}
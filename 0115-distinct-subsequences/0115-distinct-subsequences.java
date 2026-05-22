class Solution {
    private int solve(String s,String t,int ind1,int ind2,int[][] dp){

        if(ind2 == t.length()){

            return 1;
        }

        if(ind1 == s.length()){

            return 0;
        }

        if(dp[ind1][ind2] != -1){

            return dp[ind1][ind2];
        }

        if(s.charAt(ind1) == t.charAt(ind2)){

            int stay = solve(s,t,ind1 + 1,ind2,dp);
            int leave = solve(s,t,ind1 + 1,ind2 + 1,dp);

            return dp[ind1][ind2] = stay + leave;
        }
        else 
        {

            return dp[ind1][ind2] = solve(s,t,ind1 + 1,ind2,dp);
        }
    }
    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int[] d : dp){

            Arrays.fill(d,-1);
        }
        
        return solve(s,t,0,0,dp);
    }
}
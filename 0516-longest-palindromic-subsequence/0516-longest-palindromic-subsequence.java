class Solution {
    public int memo(int ind1,int ind2,String str1,String str2,int[][] dp){

        if(ind1 < 0 || ind2 < 0){

            return 0;
        }

        if(dp[ind1][ind2] != -1){

            return dp[ind1][ind2];
        }

        if(str1.charAt(ind1) == str2.charAt(ind2)){

            return dp[ind1][ind2] = 1 + memo(ind1 - 1,ind2 - 1,str1,str2,dp);
        }

        return dp[ind1][ind2] = Math.max(memo(ind1 - 1,ind2,str1,str2,dp),
                        memo(ind1,ind2 - 1,str1,str2,dp));
    }
    private int tabulation(String str1,String str2){

        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];

        for(int i = m - 1; i >= 0; i--){

            for(int j = n - 1; j >= 0; j--){

                if(str1.charAt(i) == str2.charAt(j)){

                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
                else{

                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j + 1]);
                }
          
            }
        }

        return dp[0][0];
    }
    public int longestPalindromeSubseq(String s) {

        int n = s.length();

        String rev  = new StringBuilder(s).reverse().toString();

        int[][] dp = new int[n][n];

        for(int[] d : dp){

            Arrays.fill(d,-1);
        }

        // return memo(n - 1,n - 1,s,rev,dp);
        return tabulation(s,rev);
        
    }
}
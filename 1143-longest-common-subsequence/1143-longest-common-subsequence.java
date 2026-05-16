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

        // int[][] dp = new int[n1][n2];

        // for(int[] d : dp){

        //     Arrays.fill(d,-1);
        // }
        
        // return solve(0,0,text1,text2,dp);

        // int[][] dp = new int[n1 + 1][n2 + 1];

         int[] prev = new int[n2 + 1];
        int[] curr = new int[n2 + 1];

        for(int ind1 = n1 - 1; ind1 >= 0; ind1--){

            for(int ind2 = n2 - 1; ind2 >= 0; ind2--){

                if(text1.charAt(ind1) == text2.charAt(ind2)){

                    curr[ind2] = 1 + prev[ind2 + 1];
                }
                else{

                    curr[ind2] = Math.max(curr[ind2 + 1],prev[ind2]);
                }
            }

            System.arraycopy(curr, 0, prev, 0, n2 + 1);
        }

        return prev[0];
    }
}
class Solution {

    private static int mod = (int) 1e9 + 7;
    private static int solve(String s,int start,int end,int[][] dp){

        if(start == end){

            return 1;
        }

        if(start > end){

            return 0;
        }

        if(dp[start][end] != -1){

            return dp[start][end];
        }

        

        int res = 0;

        if(s.charAt(start) == s.charAt(end)){

            int left = start + 1;
            int right = end - 1;

            while(left <= right && s.charAt(start) != s.charAt(left)){

                left++;
            }

            while(left <= right && s.charAt(end) != s.charAt(right)){

                right--;
            }

            if(left < right){

                res += 2 * solve(s,start + 1,end - 1,dp) - solve(s,left + 1,right - 1,dp);
            }
            else if(left > right){

                res += 2 * solve(s,start + 1,end - 1,dp) + 2;
            }
            else{

                res += 2 * solve(s,start + 1,end - 1,dp) + 1;
            }
        }
        else{

            res += solve(s,start + 1,end,dp) + solve(s,start,end - 1,dp) -

            solve(s,start + 1,end - 1,dp);
        }

        return dp[start][end] = res < 0 ? res + mod : res % mod;
    }
    public int countPalindromicSubsequences(String s) {
        
        int n = s.length() - 1;

        int[][] dp = new int[1001][1001];

        for(int[] d : dp){

            Arrays.fill(d,-1);
        }

        return solve(s,0,n,dp);
    }
}
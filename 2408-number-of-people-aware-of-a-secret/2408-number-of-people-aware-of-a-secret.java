class Solution {
    private static int mod = (int) 1e9+7;
    public int solve(int x,int pd,int n,int delay,int forget,int[][] dp){

        if(pd > n){

            return 1;
        }
        if(pd - x >= forget){
            return 0;
        }

        if(dp[x][pd] != -1){

            return dp[x][pd];
        }

        int ans = 0;

        if(pd - x < delay){
            ans = solve(x,pd + 1,n,delay,forget,dp);
        }
        else{

            ans = ((solve(pd,pd + 1,n,delay,forget,dp) % mod) + 
                    (solve(x,pd + 1,n,delay,forget,dp) % mod)) % mod;
        }

        return dp[x][pd] = ans;
    }
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[][] dp = new int[n + 1][n + 1];
        for(int[] d : dp){

            Arrays.fill(d,-1);
        }
        return solve(1,1,n,delay,forget,dp);
    }
}
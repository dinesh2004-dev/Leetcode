class Solution {
    public int numSquares(int n) {
        // if(n <= 0){

        //     return 0;
        // }

        // int ans = n;

        // for(int i = 1; i * i <= n; i++){

        //     int val = 1 + numSquares(n - (i * i));

        //     ans = Math.min(ans,val);
        // }
        // return ans;

        int dp[] = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            int ans = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){

                int val = 1 + dp[i - j * j];
                ans = Math.min(val,ans);
            }
            dp[i] = ans;
        }
        return dp[n];
    }
}
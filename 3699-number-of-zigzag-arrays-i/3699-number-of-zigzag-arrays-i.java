class Solution {
    private int l;
    private int r;
    private int mod = (int) 1e9 + 7;

    long[][][] dp;
    private long solve(int ind,boolean dir,int last){

       int nxt = dir ? last + 1 : last - 1;

       if(nxt < l || nxt > r){

            return 0;
       }

       if(ind == 0){

            return 1;
       }

       int fi = dir ? 1 : 0;

       if(dp[ind][fi][last - l] != -1){

            return dp[ind][fi][last - l];
       }

       long res = (solve(ind - 1,!dir,nxt) + solve(ind,dir,nxt)) % mod;

       return dp[ind][fi][last - l] = res;

        
    }
    public int zigZagArrays(int n, int l, int r) {
        
       this.l = l;
       this.r = r;

       int k = (r - l + 1);

       dp = new long[n][2][k];

       for(long[][] a : dp){

            for(long[] b : a){

                Arrays.fill(b,-1);
            }
       } 

       long ans = 0;

       for(int start = l; start <= r; start++){

            ans = (ans + solve(n - 1,true,start) + 
                        solve(n - 1,false,start)) % mod;
       }

       return (int) ans;
    }
}
class Solution {
    //  private static final int MODULO = (int)1e9+7;
    public int change(int amount, int[] coins) {
        int N = coins.length;
        long[][] dp = new long[N][amount + 1];

      for(int i = 0; i <= amount;i++){
            if(i % coins[0] == 0){

                dp[0][i] = 1;
            }
      }

      for(int i = 1; i < N; i++){
        for(int j = 0; j <= amount; j++){

            int notPick = (int)dp[i - 1][j];

            int pick = 0;

            if(j >= coins[i]){

                pick = (int)dp[i][j - coins[i]];
            }

            dp[i][j] = (pick + notPick);
        }
      }

      return (int)dp[N - 1][amount];
    }
}
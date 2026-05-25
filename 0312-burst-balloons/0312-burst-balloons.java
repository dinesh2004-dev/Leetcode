class Solution {
    private int solve(int[] newNums,int i,int j,int[][] dp){

        if(i > j){

            return 0;
        }

        if(dp[i][j] != -1){

            return dp[i][j];
        }

        int res = (int) -1e9;

        for(int k = i; k <= j; k++){

            int burst = newNums[i - 1] * newNums[k] * newNums[j + 1]
                            + solve(newNums,i,k - 1,dp) + solve(newNums,k + 1,j,dp);

            res = Math.max(res,burst);
        }

        return dp[i][j] = res;
    }
    public int maxCoins(int[] nums) {
        
        int n = nums.length;

        int[] newNums = new int[n + 2];

        newNums[0] = 1;
        newNums[n + 1] = 1;

        int[][] dp = new int[n + 2][n + 2];

        for(int[] d : dp){

            Arrays.fill(d,-1);
        }

        for(int i = 0; i < n; i++){

            newNums[i + 1] = nums[i];
        }

        return solve(newNums,1,n,dp);
    }
}
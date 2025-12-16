class Solution {
    private int memoize(int[] nums,int i,int j,int[][] dp){

        if(i > j){

            return 0;
        }

        if(dp[i][j] != -1){

            return dp[i][j];
        }

        int maxi = Integer.MIN_VALUE;

        for(int k = i; k <= j; k++){

           int coins = (nums[i - 1] * nums[k] * nums[j + 1]) +
                        memoize(nums,i,k - 1,dp) + memoize(nums,k + 1,j,dp);
            
            maxi = Math.max(coins,maxi);
        }

        return dp[i][j] = maxi;
    }
    private int tabulation(int[] nums){

        int n = nums.length;

        int[][] dp = new int[n][n];

        
        for(int i = n - 2; i >= 1; i--){

            for(int j = 1; j <= n - 2; j++){

                if(i > j){
                    continue;
                }

                int maxi = Integer.MIN_VALUE;

                for(int k = i; k <= j; k++){

                    int coins = (nums[i - 1] * nums[k] * nums[j + 1]) +
                        dp[i][k - 1] + dp[k + 1][j];

                    maxi = Math.max(maxi,coins);

                }

                dp[i][j] = maxi;


            }

            
        }

       

        return dp[1][n - 2];
    }
    public int maxCoins(int[] nums) {
        //your code goes here

        int n = nums.length;

        int[] newNums = new int[n + 2];

        newNums[0] = 1;
        newNums[n + 1] = 1;

        int dp[][] = new int[n + 2][n + 2];

        for(int[] d : dp){

            Arrays.fill(d,-1);
        }

        for(int i = 0; i  < n; i++){

            newNums[i + 1] = nums[i];
        }

        // return memoize(newNums,1,n,dp);

        return tabulation(newNums);
    }
}
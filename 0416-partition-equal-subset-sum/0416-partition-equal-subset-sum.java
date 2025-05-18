class Solution {
    public boolean func(int n,int[] arr,int k){

        boolean[][] dp = new boolean[n + 1][k + 1];

        for(int i = 0; i <= n; i++){

            dp[i][0] = true;
        }
        if(arr[0] <= k){

            dp[0][arr[0]] = true;
        }

        for(int i = 1; i <= n; i++){

            for(int j = 1; j <= k;j++){

                boolean notPick = dp[i - 1][j];

                boolean pick = false;

                if(j >= arr[i]){

                    pick = dp[i - 1][j - arr[i]];
                }

                dp[i][j] = pick || notPick;

            }
        }

        return dp[n][k];
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        int n = nums.length;

            if(sum % 2 == 1){
                return false;
            }
            else{

                int k = sum / 2;

                return func(n - 1,nums,k);
            }
    }
}
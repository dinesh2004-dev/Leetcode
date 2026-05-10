class Solution {
    public int maximumJumps(int[] nums, int target) {
        
        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp,-1);

        dp[0] = 0;

        for(int i = 0; i < n; i++){

            if(dp[i] == -1){

                continue;
            }

            for(int j = i + 1; j < n; j++){

                int diff = nums[j] - nums[i];

                if((-1 * target) <= diff && diff <= target){

                    dp[j] = Math.max(dp[j],1 + dp[i]);
                }
            }
        }

        return dp[n - 1];
    }
}
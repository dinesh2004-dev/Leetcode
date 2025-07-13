class Solution {
    public int solve(int[] nums,int n,int i,int[] dp){
        if(i == n){
            return 1;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int count = 1;
        for(int j = i + 1; j < n; j++){
            if(nums[i] < nums[j]){
                count = Math.max(count,1 + solve(nums,n,j,dp));
            }
        }
        return dp[i] = count;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);

        for(int i = 0; i < n; i++){
            res = Math.max(res,solve(nums,n,i,dp));
        }
        return res;
    }
}
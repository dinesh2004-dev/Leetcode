class Solution {
    public int solve(int[] nums,int ind,int n,int even,int[][] dp){
        if(ind == n){
            return 0;
        }
        if(dp[ind][even] != -1){
            return dp[ind][even];
        }
        
        int notPick = solve(nums,ind + 1,n,even,dp);
        int pick = 0;
       if((nums[ind] % 2 == 0 && even == 0) || (nums[ind] % 2 != 0 && even == 1)){
        pick = 1 + solve(nums,ind + 1,n,(nums[ind] % 2 == 0) ? 1 : 0,dp);
       }
        return dp[ind][even] = Math.max(pick,notPick);

    }
    public int maximumLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        int maxLen = Math.max(solve(nums,0,n,1,dp),solve(nums,0,n,0,dp));
         int even = 0;
        int odd =0;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0)even++;
            else odd++;
        }
        return Math.max(odd,Math.max(even,maxLen));
    }
}
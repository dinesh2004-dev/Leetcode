class Solution {
    private int solve(int ind,int prev,int[] nums,int[][] dp){

        if(ind == nums.length){

            return 0;
        }

        if(dp[ind][prev + 1] != -1){

            return dp[ind][prev + 1];
        }

        int notPick = solve(ind + 1,prev,nums,dp);

        int pick = 0;

        if(prev == -1 || prev >= 0 && nums[ind] > nums[prev]){

            pick = 1 + solve(ind + 1,ind,nums,dp);
        }

        return dp[ind][prev + 1] = Math.max(pick,notPick);
    }
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[][] dp = new int[n + 1][n + 1];

        for(int[] d : dp){

            Arrays.fill(d,-1);
        }
        
        return solve(0,-1,nums,dp);
    }
}
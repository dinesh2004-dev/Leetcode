class Solution {

    public int solve(int ind,int[] energy,int k,int[] dp){

        if(ind >= energy.length){

            return 0;
        }

        if(dp[ind] != - 1){

            return dp[ind];
        }

        return dp[ind] = energy[ind] + solve(ind + k,energy,k,dp);
    }
    public int maximumEnergy(int[] energy, int k) {

        int n = energy.length;

        int maxEnergy = Integer.MIN_VALUE;

        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        for(int i = 0; i < n; i++){

            maxEnergy = Math.max(maxEnergy,solve(i,energy,k,dp));
        }

        return maxEnergy;
        
    }
}
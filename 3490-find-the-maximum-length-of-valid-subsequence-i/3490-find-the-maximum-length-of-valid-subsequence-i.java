class Solution {
   
    public int maximumLength(int[] nums) {
       int n = nums.length;
        int[][] dp = new int[n + 1][2];
        
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int even = 0; even <= 1; even++) {
                int notPick = dp[ind + 1][even];
                int pick = 0;
                
                if ((nums[ind] % 2 == 0 && even == 0) || (nums[ind] % 2 != 0 && even == 1)) {
                    pick = 1 + dp[ind + 1][(nums[ind] % 2 == 0) ? 1 : 0];
                }
                
                dp[ind][even] = Math.max(pick, notPick);
            }
        }
        
         int even = 0;
        int odd =0;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0)even++;
            else odd++;
        }
        int alternatingEven = dp[0][0];  // Start with even
        int alternatingOdd = dp[0][1];   // Start with odd
        return Math.max(Math.max(odd,even),Math.max( alternatingEven, alternatingOdd));
    }
}
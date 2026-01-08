class Solution {
    static final int NEG_INF = -1000000000;
    public  int solve(int[] arr1,int ind1,int[] arr2,int ind2,int[][] dp){
        
        if(arr1.length == ind1 || arr2.length == ind2){
            
            
            return NEG_INF;
        }

        if(dp[ind1][ind2] != Integer.MIN_VALUE){

            return dp[ind1][ind2];
        }

        int pick = arr1[ind1] * arr2[ind2] +
                Math.max(0,solve(arr1,ind1 + 1,arr2,ind2 + 1,dp));
        
        int skip1 = solve(arr1,ind1 + 1,arr2,ind2,dp);
         int skip2 = solve(arr1,ind1,arr2,ind2 + 1,dp);
    
        
        
        return Math.max(pick,Math.max(skip1,skip2));
        
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {

        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n+1][m+1];

        
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                dp[i][j] = Integer.MIN_VALUE / 2;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int pick = nums1[i] * nums2[j]
                        + Math.max(0, dp[i+1][j+1]);
                int skip1 = dp[i+1][j];
                int skip2 = dp[i][j+1];
                dp[i][j] = Math.max(pick, Math.max(skip1, skip2));
            }
        }
        return dp[0][0];
    }
}
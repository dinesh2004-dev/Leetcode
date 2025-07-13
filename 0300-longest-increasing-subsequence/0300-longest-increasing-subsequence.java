class Solution {
    // public int solve(int[] nums,int ind,int prev_ind,int n){
    //     if(ind == n){
    //         return 0;
    //     }

    //     int len = solve(nums,ind + 1,prev_ind,n);
    //     if(prev_ind == - 1 || nums[prev_ind] < nums[ind]){
    //         len = Math.max(len,1 + solve(nums,ind + 1,ind,n));
    //     }
    //     return len;
    // }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n + 1][n + 1];
        for(int i = n - 1; i >= 0; i--){
            for(int j = i - 1; j >= -1; j--){
                
                    int len = dp[i + 1][j + 1];
                    if(j == -1 || nums[j] < nums[i]){
                        len = Math.max(len, 1 + dp[i + 1][i + 1]);
                    }
                    dp[i][j + 1] = len;
                }
            }
            return dp[0][-1 + 1];
        }
        
    }
    

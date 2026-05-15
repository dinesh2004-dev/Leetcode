class Solution {
    private int targetSum(int ind,int[] nums,int target){

        //  if(ind == nums.length){

        //     if(target == 0){

        //         return 1;
        //     }

        //     return 0;
        // }
       

        // int notPick = targetSum(ind + 1,nums,target);

        // int pick = 0;

        // if(target - nums[ind] >= 0){

        //     pick = targetSum(ind + 1,nums,target - nums[ind]);
        // }

        // return pick + notPick;

        int n = nums.length;

        int[][] dp = new int[n + 1][target + 1];

        dp[n][0] = 1;

        for(int i = n - 1; i >= 0; i--){

            for(int tar = target; tar >= 0; tar--){

                int notPick = dp[i + 1][tar];
                
                int pick = 0;

                if(tar - nums[i] >= 0){

                    pick = dp[i + 1][tar - nums[i]];
                }

                dp[i][tar] = pick + notPick;
            }
        }

        return dp[0][target];
    }
    public int findTargetSumWays(int[] nums, int target) {
        
        int n = nums.length;

        int total = 0;

        for(int num : nums){

            total += num;
        }

        int sum = total - target;
       
       if(sum < 0 || sum % 2 != 0){

            return 0;
       }

       return targetSum(0,nums,sum / 2);
    }
}
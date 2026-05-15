class Solution {
    public boolean targetSum(int ind,int[] nums,int target){

        //  if(ind == nums.length){

        //     return false;
        // }

        // if(target == 0){

        //     return true;
        // }

       

        // boolean notPick = targetSum(ind + 1,nums,target);
        // boolean pick = false;

        // if(target - nums[ind] >= 0){

        //     pick = targetSum(ind + 1,nums,target - nums[ind]);
        // }

        // return pick || notPick;

        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][target + 1];

        for(int i = 0; i <= n; i++){

            dp[i][0] = true;
        }

        

        for(int i = n - 1; i >= 0; i--){

            for(int tar = 1; tar <= target; tar++){

                boolean notPick = dp[i + 1][tar];
               
                boolean pick = false;

                if(tar - nums[i] >= 0){

                    pick = dp[i + 1][tar - nums[i]];

                    
                }

                dp[i][tar] = pick || notPick;

                
            }
        }

       

            

       
        return dp[0][target];

       
    }
    public boolean canPartition(int[] nums) {
        
        int n = nums.length;

        int sum = 0;

        for(int num : nums){

            sum += num;
        }

        if(sum % 2 != 0){

            return false;
        }

        return targetSum(0,nums,sum / 2);
    }
}
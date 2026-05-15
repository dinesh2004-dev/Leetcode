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

        boolean[] dp = new boolean[target + 1];

        dp[0] = true;
        
        for(int i = n - 1; i >= 0; i--){

            for(int tar = target; tar >= 0; tar--){

                boolean notPick = dp[tar];
               
                boolean pick = false;

                if(tar - nums[i] >= 0){

                    pick = dp[tar - nums[i]];

                    
                }

                dp[tar] = pick || notPick;
                
            }
        }

       

            

       
        return dp[target];

       
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
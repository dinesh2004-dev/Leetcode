class Solution {
    public int minimumCost(int[] nums) {
        
        if(nums.length == 3){

            return nums[0] + nums[1] + nums[2];
        }
        int ele1 = nums[0];

        Arrays.sort(nums);

        if(ele1 == nums[0]){

            return ele1 + nums[1] + nums[2];
        }

        else if(ele1 == nums[1]){

            return ele1 + nums[0] + nums[2];
        }
        else{

           return ele1 + nums[0] + nums[1];
        }
    }
}
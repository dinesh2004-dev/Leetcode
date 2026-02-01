class Solution {
    public int minimumCost(int[] nums) {
        
       

        int firstSmaller = Integer.MAX_VALUE,secondSmaller = Integer.MIN_VALUE;

        for(int i = 1; i < nums.length; i++){

            if(nums[i] < firstSmaller){

                secondSmaller = firstSmaller;

                 firstSmaller = nums[i];
            }
            else if(nums[i] < secondSmaller){

                secondSmaller = nums[i];
            }
        }

       return nums[0] + firstSmaller + secondSmaller;
    }
}
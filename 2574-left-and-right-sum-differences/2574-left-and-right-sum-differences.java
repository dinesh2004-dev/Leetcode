class Solution {
    public int[] leftRightDifference(int[] nums) {
        
        int totalSum = 0;

        int n = nums.length;

        for(int i = 0; i < n; i++){

            totalSum = totalSum + nums[i];
        }

        int[] res = new int[n];

        int leftSum = 0;

        for(int i = 0; i < n; i++){

          

           int rightSum = totalSum - leftSum - nums[i];

           res[i] = Math.abs(rightSum - leftSum);

            leftSum += nums[i];
        }

        return res;
    }
}
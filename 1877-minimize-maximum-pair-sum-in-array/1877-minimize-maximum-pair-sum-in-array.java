class Solution {
    public int minPairSum(int[] nums) {
        
        int n = nums.length;

        Arrays.sort(nums);

        int low = 0,high = n - 1;

        int maxSum = Integer.MIN_VALUE;

        while(low < high){

            int sum = nums[low] + nums[high];

            maxSum = Math.max(sum,maxSum);

            low++;
            high--;
        }
        
        return maxSum;
    }
}
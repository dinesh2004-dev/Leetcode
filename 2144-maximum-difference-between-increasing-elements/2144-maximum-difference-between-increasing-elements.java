class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;

        int maxi = Integer.MIN_VALUE;

        for(int j = 0; j < n; j++){

            for(int i = j + 1; i < n; i++){

                if(nums[j] < nums[i]){

                    int diff = nums[i] - nums[j];

                    maxi = Math.max(maxi,diff);
                }
            }
        }

        return (maxi == Integer.MIN_VALUE) ? -1 : maxi;
    }
}
class Solution {
    public int longestSubarray(int[] nums) {

        int r = 0, l = 0,n = nums.length;

        int zeros = 0;

        int maxLen = Integer.MIN_VALUE;

        while(r < n){

            if(nums[r] == 0){

                zeros++;
            }
            while(zeros > 1){
                if(nums[l] == 0){

                    zeros--;
                }
                l++;
            }

            maxLen = Math.max(maxLen,r - l + 1);

            r++;

        }
        return maxLen  - 1;
        
    }
}
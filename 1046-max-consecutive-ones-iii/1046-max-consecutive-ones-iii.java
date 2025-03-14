class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int r = 0,l = 0,n = nums.length;

        int zeros = 0;

        int maxOnes = Integer.MIN_VALUE;

        while(r < n){

            if(nums[r] == 0){

                zeros++;
            }
            while(zeros > k){

                if(nums[l] == 0){

                    zeros--;
                }
                l++;
            }

            maxOnes = Math.max(maxOnes,r - l + 1);

            r++;


        }
        return maxOnes;
    }
}
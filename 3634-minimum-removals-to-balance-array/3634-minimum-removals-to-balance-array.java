class Solution {
    public int minRemoval(int[] nums, int k) {

        Arrays.sort(nums);
        
        int n = nums.length;

        int l = 0,r = 0;

        int maxLen = 0;

        while(r < n){

            while((long) nums[r] > (long) nums[l] * k){

                l++;
            }

            maxLen = Math.max(maxLen,r - l + 1);
            r++;
        }

        return n - maxLen;
    }
}
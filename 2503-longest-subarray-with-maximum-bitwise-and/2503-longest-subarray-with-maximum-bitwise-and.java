class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxAnd = Arrays.stream(nums).max().getAsInt();
       
       
        int maxLen = 0;
        int currLen = 0;
        for(int num : nums){
            if(num == maxAnd){
                currLen++;
            }
            else{
                maxLen = Math.max(maxLen,currLen);
                currLen = 0;
            }
        }
        return Math.max(currLen,maxLen);
    }
}
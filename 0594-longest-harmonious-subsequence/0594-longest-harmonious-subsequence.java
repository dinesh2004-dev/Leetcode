class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);
        int left = 0,right = 1;
        while(right < n){
            int diff = nums[right] - nums[left];
            if(left < right && diff > 1){
                left++;
                diff = nums[right] - nums[left];
            }
            if(diff == 1){
                count = Math.max(count,right - left + 1);
            }
            right++;
        }
        return count;
    }
}
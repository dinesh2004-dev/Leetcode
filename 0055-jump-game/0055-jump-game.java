class Solution {
    public boolean solve(int[] nums, int start, Boolean[] memo) {
        
        if (start >= nums.length - 1) {
            return true;
        }
        
        if (memo[start] != null) {
            return memo[start];
        }
        
        if (nums[start] == 0) {
            memo[start] = false;
            return false;
        }
        
        
        for (int i = 1; i <= nums[start]; i++) {
            if (solve(nums, start + i, memo)) {
                memo[start] = true;
                return true;
            }
        }
        
        memo[start] = false;
        return false;
    }
    
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int reachable = 0;

        for(int i = 0; i < n; i++){
            if(i > reachable){
                return false;
            }
            reachable = Math.max(reachable,i + nums[i]);
        }
        return true;
    }
}
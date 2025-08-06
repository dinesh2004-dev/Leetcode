class Solution {
    public boolean solve(int[] nums, int start, Boolean[] memo) {
        // Can reach or go beyond last index
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
        
        // Try all possible jumps from current position
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
        Boolean[] memo = new Boolean[nums.length];
        return solve(nums, 0, memo);
    }
}
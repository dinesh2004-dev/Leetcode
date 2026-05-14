class Solution {
    public int findDuplicate(int[] nums) {
        
        int fast = nums[0];
        int slow = nums[0];

        do{

            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while(slow != fast);

        int slow2 = nums[0];

        while(slow != slow2){

            slow2 = nums[slow2];
            slow = nums[slow];
        }

        return slow;
    }
}
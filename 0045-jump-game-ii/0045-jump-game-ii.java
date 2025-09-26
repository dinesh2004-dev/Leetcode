class Solution {
    public int jump(int[] nums) {
        
        int n = nums.length;
        int minJump = 0,farthest = 0, currEnd = 0;

        for(int i = 0; i < n - 1; i++){

            farthest = Math.max(farthest,nums[i] + i);

            if(i == currEnd){

                minJump++;
                currEnd = farthest;
            }
        }

        return minJump;
    }
}
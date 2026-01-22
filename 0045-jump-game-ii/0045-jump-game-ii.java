class Solution {
    public int jump(int[] nums) {
        
        int n = nums.length;
        int currEnd = 0,minJumps = 0,farthestJump = 0;

        for(int i = 0; i < n - 1; i++){

            farthestJump = Math.max(farthestJump,nums[i] + i);

            if(i == currEnd){

                currEnd = farthestJump;
                minJumps++;
            }
        }

        return minJumps;
    }
}
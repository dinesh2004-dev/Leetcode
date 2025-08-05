class Solution {
    public int jump(int[] nums) {
        int n = nums.length - 1;
        int currEnd = 0,farthest = 0,jump = 0;

        for(int i = 0; i < n; i++){
            farthest = Math.max(farthest,i + nums[i]);
            if(i == currEnd){
                jump++;
                currEnd = farthest;
            }
        }
        return jump;

    }
}
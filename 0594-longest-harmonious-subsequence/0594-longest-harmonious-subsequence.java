class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++){
            int min = nums[i];
            int max = nums[i];
            for(int j = i + 1; j < n;j++){
                min = Math.min(min,nums[j]);
                max = Math.max(max,nums[j]);
                 if((max - min) == 1 ){
                    count = Math.max(count,j - i + 1);
                 }
            }
           
        }
        return count;
    }
}
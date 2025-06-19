class Solution {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;
        
        int ans = 1;
        Arrays.sort(nums);
        int min = nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] - min > k){
                min = nums[i];
                ans++;
            }
        }
        return ans;
    }
}
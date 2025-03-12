class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int i = 0, j = nums.length - 1;

        int cnt = 0;

        while( i < j){

            int num = nums[i] + nums[j];
            if(num == k){

                cnt++;
                i++;
                j--;
            }
            else if(num > k){

                j--;
            }
            else if(num < k){

                i++;
            }
           

                
            }
            
            
            
        
        return cnt;
    }
}
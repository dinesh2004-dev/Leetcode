class Solution {
    public int triangleNumber(int[] nums) {
        
        int n = nums.length;

        Arrays.sort(nums);

        int cnt = 0;

        for(int i = n - 1; i >= 2; i--){

            int left = 0,right = i - 1;

            while(left < right){

                int sum = nums[left] + nums[right];

                if(sum > nums[i]){

                    cnt += right - left;
                    right--;
                }
                else{

                    left++;
                }
            }
        }

        return cnt;
    }
}
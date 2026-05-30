class Solution {
    private void reverse(int[] nums,int left,int right){

        while(left <= right){

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
    public void nextPermutation(int[] nums) {
        
        int n = nums.length;

        int idx = -1;

        for(int i = n - 2; i >= 0; i--){

            if(nums[i] < nums[i + 1]){

                idx = i;
                break;
            }
        }

        if(idx == -1){

            reverse(nums,0,n - 1);
            return;
        }

        for(int i = n - 1; i >= 0; i--){

            if(nums[idx] < nums[i]){

                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        reverse(nums,idx + 1,n - 1);
    }
}
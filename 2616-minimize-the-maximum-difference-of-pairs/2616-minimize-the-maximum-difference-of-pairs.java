class Solution {
    public int minimizeMax(int[] nums, int p) {

        if(p == 0){

            return 0;
        }
        
        int n = nums.length;

        Arrays.sort(nums);

        int low = 0,high = nums[n - 1] - nums[0];

        while(low <= high){

            int mid = low + (high - low) / 2;

            int pairs = 0;

            for(int i = 0; i < n - 1; i++){

                if((nums[i + 1] - nums[i]) <= mid){

                    pairs++;
                    i++;
                }
            }

            if(pairs >= p){

                high = mid - 1;
            }
            else{

                low = mid + 1;
            }
        }

        return low;
    }
}
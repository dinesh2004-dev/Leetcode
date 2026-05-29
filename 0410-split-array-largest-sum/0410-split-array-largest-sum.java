class Solution {
    private int countPartitions(int[] nums,int k){

        int n = nums.length;

        int subarraySum = 0,partitions= 1;

        for(int i = 0; i < n; i++){

            if(subarraySum + nums[i] <= k){

                subarraySum += nums[i];
            }
            else{

                subarraySum = nums[i];
                partitions++;
            }
        }

        return partitions;
    }
    public int splitArray(int[] nums, int k) {
        
        int n = nums.length;

        int low = 0,high = 0;

        for(int i = 0; i < n; i++){

            low = Math.max(low,nums[i]);
            high = high + nums[i];
        }

        while(low <= high){

            int mid = low + (high - low) / 2;

            int partitions = countPartitions(nums,mid);

            if(partitions > k){

                low = mid + 1;
            }
            else{

                high = mid - 1;
            }
        }

        return low;
    }
}
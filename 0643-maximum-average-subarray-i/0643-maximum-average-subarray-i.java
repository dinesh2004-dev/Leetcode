class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int n = nums.length,i = 0, j = 0;

        double sum = 0;

        double maxAvg = Integer.MIN_VALUE;

        int len = 0;

        while(j < n){

            sum += (double)nums[j];

            len++;

            while(j < n && len > k){

                sum -= (double)nums[i];

                i++;

                len--;
            }
            if(len == k){

                maxAvg = Math.max(maxAvg,sum/k);
            }
            j++;

        }
        return maxAvg;
    }
}
class Solution {
    public void reverse(int[] arr){

        int l = 0,r = arr.length - 1;

        while(l < r){

            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            l++;
            r--;
        }
    }
    public long maximumHappinessSum(int[] happiness, int k) {
        
        Arrays.sort(happiness);
        reverse(happiness);

        long maxSum = Integer.MIN_VALUE;
        int decrementBy = 0;
        int j = 0;
        int n = happiness.length;
        long sum = 0;

        for(int i = 0; i < k; i++){
            
            if(happiness[j] + decrementBy >= 0){

                sum = sum + happiness[j++] + decrementBy;

            }
            maxSum = Math.max(maxSum,sum);
            decrementBy--;
            
        }

        return maxSum;
    }
}
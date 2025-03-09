class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;

        int[] prefixSum = new int[n];

        int[] suffixSum = new int[n];

        prefixSum[0] = 1;

        int left = nums[0];

        for(int i = 1; i < n; i++){

            prefixSum[i] = left;

            left = nums[i] * left;
        }

        suffixSum[n - 1] = 1;

        int right = nums[n  - 1];

        for(int i = n - 2; i >= 0; i--){
            suffixSum[i] = right;

            right = right * nums[i];
        }

        int ans[] = new int[n];

        for(int i = 0; i < n ; i++){

            ans[i] = prefixSum[i] * suffixSum[i];
        }
        return ans;
        
    }
}
class Solution {
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int mod = 1000000007;
        
        Arrays.sort(nums);

        int[] powers = new int[n];
        powers[0] = 1;

        for(int i = 1; i < n; i++){
            powers[i] = (powers[i - 1] * 2) % mod;
        }

        int start = 0,end = n - 1,result = 0;

        while(start <= end){
            if((nums[start] + nums[end]) <= target){
                result = (result + powers[end - start]) % mod;
                start++;
            }
            else{
                end--;
            }
        }
        return result;
    }
}
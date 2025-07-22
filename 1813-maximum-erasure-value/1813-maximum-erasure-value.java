class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int maxScore = Integer.MIN_VALUE;
        int l = 0,r = 0,sum = 0;
        Map<Integer,Integer> mpp = new HashMap<>();
        while(r < n){
            mpp.put(nums[r],mpp.getOrDefault(nums[r],0)+1);
            sum += nums[r];
            int len = r - l + 1;
            while(len > mpp.size()){
                mpp.put(nums[l],mpp.get(nums[l]) - 1);
                sum -= nums[l];
                if(mpp.get(nums[l]) == 0){
                    mpp.remove(nums[l]);
                }
                l++;
                 len = r - l + 1;
                 
               
            }
            maxScore = Math.max(maxScore,sum);
            r++;
        }
        return maxScore;
    
    }
}
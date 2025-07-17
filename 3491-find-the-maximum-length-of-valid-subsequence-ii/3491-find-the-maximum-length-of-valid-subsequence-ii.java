class Solution {
     private Map<String, Integer> dp;
    public int maximumLength(int[] nums,int k,int ind,int prev,int prevmod){
        if(ind == nums.length){
            return 0;
        }
       String key = ind + "," + prev + "," + prevmod;
       if(dp.containsKey(key)){
         return dp.get(key);
       }
        
        int notPick = maximumLength(nums,k,ind + 1,prev,prevmod);
        int pick = 0;
        if(prev == -1){
            pick = 1 + maximumLength(nums,k,ind + 1,ind,prevmod);
        }
        else if(prevmod == -1){
            prevmod = (nums[ind] + nums[prev]) % k;
            pick =  1 + maximumLength(nums,k,ind + 1,ind,prevmod);
        }
        else{
            if((nums[ind] + nums[prev]) % k == prevmod){
                 pick =  1 + maximumLength(nums,k,ind + 1,ind,prevmod);
            }
            
            
        }
        int result = Math.max(pick,notPick);
        dp.put(key,result);
        return result;
    }
    public int maximumLength(int[] nums, int k) {
        // int n = nums.length;
        // dp = new HashMap<>();
        // int res = maximumLength(nums,k,0,-1,-1);
        // return res;

        int n = nums.length;
        int[][] dp = new int[k][k];
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int currRem = nums[i] % k;
            for(int prevRem = 0; prevRem < k; prevRem++){
                dp[currRem][prevRem] = Math.max(dp[currRem][prevRem],1 + 
                                        dp[prevRem][currRem]);
                ans = Math.max(ans,dp[currRem][prevRem]);
            }
        }
        return ans;
    }
}
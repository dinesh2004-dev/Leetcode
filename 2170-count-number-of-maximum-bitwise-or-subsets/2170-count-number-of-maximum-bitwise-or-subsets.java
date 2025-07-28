class Solution {
    public int subsets(int[] nums,int ind,int totalOR,int currOR){
        if(ind == nums.length){
            return (totalOR == currOR) ? 1 : 0;
        }
        // if(totalOR == currOR){
        //     return 1;
        // }
        // int cnt = 0;
        // int oldOR = currOR;
        // currOR = currOR | nums[ind];
        // cnt += subsets(nums,ind + 1,totalOR,currOR);
        // currOR = oldOR;
        // cnt += subsets(nums,ind + 1,totalOR,currOR);
        // return cnt;

        return subsets(nums,ind + 1,totalOR,currOR | nums[ind]) + subsets(nums,ind + 1,totalOR,currOR);
    }
    public int countMaxOrSubsets(int[] nums) {
        int totalOR = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            totalOR = totalOR | nums[i];
        }

        int res = subsets(nums,0,totalOR,0);
        return res;
    }
}
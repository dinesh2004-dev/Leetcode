class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        
        int n = nums.size();
        int maxK = 0,prev = 0,i = 0;

        while(i < n){

            int start = i;

            while(i + 1 < n && nums.get(i + 1) > nums.get(i)){

                i++;
            }

            int curr = i - start + 1;

            maxK = Math.max(maxK,Math.max(curr / 2,Math.min(curr,prev)));

            prev = curr;

            i++;
        }

        return maxK;
    }
}
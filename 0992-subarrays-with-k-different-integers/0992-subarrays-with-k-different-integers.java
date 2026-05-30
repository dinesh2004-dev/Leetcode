class Solution {

    private int subarraysWithAtmostK(int[] nums,int k){

        Map<Integer,Integer> mpp = new HashMap<>();

        int left = 0,right = 0,ans = 0;

        while(right < nums.length){

            mpp.put(nums[right],mpp.getOrDefault(nums[right],0)+1);

            while(mpp.size() > k){

                mpp.put(nums[left],mpp.get(nums[left]) - 1);

                if(mpp.get(nums[left]) == 0){

                    mpp.remove(nums[left]);
                }

                left++;
            }

            ans += (right - left + 1);

            right++;
        }

        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return subarraysWithAtmostK(nums,k) - subarraysWithAtmostK(nums,k - 1);
    }
}
class Solution {
    private int lowerBound(List<Integer> list,int key){

        int low = 0,high = list.size() - 1;

        while(low <= high){

            int mid = low + ( high - low) / 2;

            if(list.get(mid) >= key){

                high = mid - 1;
            }
            else{

                low = mid + 1;
            
            }
        }

        return low;
    }
    public int lengthOfLIS(int[] nums) {
        
        List<Integer> list = new ArrayList<>();

        int n = nums.length;

        list.add(nums[0]);

        for(int i = 1; i < n; i++){

            if(list.get(list.size() - 1) < nums[i]){

                list.add(nums[i]);
            }
            else{

                int idx = lowerBound(list,nums[i]);
                list.set(idx,nums[i]);
            }
        }

        return list.size();
    }
}
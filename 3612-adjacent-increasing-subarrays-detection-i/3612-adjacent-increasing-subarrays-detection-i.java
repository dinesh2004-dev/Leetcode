class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {

        int n = nums.size();
        
        for(int i = 0; i + 2 * k <= n; i++){

            boolean first = true;

            for(int j = i; j < i + k - 1; j++){

                if(nums.get(j) >= nums.get(j + 1)){

                    first = false;
                    break;
                }
            }

            if(!first){
                continue;
            }

            boolean second = true;

            for(int j = i + k; j < i + 2 * k - 1; j++){
                if(nums.get(j) >= nums.get(j + 1)){

                    second = false;
                    break;
                }

            }

            if(second){
                return true;
            }
        }

        return false;
    }
}
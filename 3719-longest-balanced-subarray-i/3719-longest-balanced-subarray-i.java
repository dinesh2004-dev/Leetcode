class Solution {
    public int longestBalanced(int[] nums) {
        
        int n = nums.length;

        int maxLen = 0;

       

        for(int i = 0; i < n; i++){

            int even = 0,odd = 0;
            HashSet<Integer> seen = new HashSet<>();
            for(int j = i; j < n; j++){

                if(!seen.contains(nums[j])){

                    if(nums[j] % 2 == 0){

                        even++;
                    }
                    else{

                        odd++;
                    }

                }

              
            if(even != 0 && odd != 0){
                if(even == odd){

                     maxLen = Math.max(maxLen,j - i + 1);
                }
            }

                seen.add(nums[j]);
                

            }
        }

        return maxLen;
    }
}
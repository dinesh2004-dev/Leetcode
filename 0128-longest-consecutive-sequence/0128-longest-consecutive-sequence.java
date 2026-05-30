class Solution {
    public int longestConsecutive(int[] nums) {
        
        int n = nums.length;

        if(n == 0){

            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for(int ele : nums){

            set.add(ele);
        }

        int maxLen = 0;

        for(int ele : set){

            if(!set.contains(ele - 1)){

                int count = 1;
                int currNum = ele;

                while(set.contains(currNum + 1)){

                    currNum++;
                    count++;
                }

                maxLen = Math.max(maxLen,count);
            }
        }

        return maxLen;
    }
}
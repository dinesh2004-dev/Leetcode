class Solution {
    public int findRes(int num){

        

        for(int i = 1; i <= num; i++){

            int or = i | (i + 1);

            if(or == num){

                return i;
            }
        }

        return -1;
    }
    public int[] minBitwiseArray(List<Integer> nums) {
        
        int n = nums.size();
        int ans[] = new int[n];
        int a = 0;

        for(int num : nums){

            int res = findRes(num);

            ans[a++] = res;
        }

        return ans;
    }
}
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;

        int[][] res = new int[n / 3][3];

        Arrays.sort(nums);

        for(int i = 0; i < n; i += 3){
            int diff1 = nums[i + 1] - nums[i];
            int diff2 = nums[i + 2] - nums[i];
            int diff3 = nums[i + 2] - nums[i + 1];

            if(diff1 <= k && diff2 <= k && diff3 <= k){
                
                int row = i / 3;
                System.out.println(row);
                res[row][0] = nums[i];
                res[row][1] = nums[i+1];
                res[row][2] = nums[i+2];
            }
            else{
                return new int[][]{};
            }
        }
        return res;
    }
}
class Solution {
    public int minMoves(int[] nums, int limit) {
        
        int n = nums.length;

        int[] diff = new int[2 * limit + 2];

        for(int i = 0; i < n / 2; i++){

            int val1 = Math.min(nums[i],nums[n - 1 - i]);
            int val2 = Math.max(nums[i],nums[n - 1 - i]);

            diff[2] += 2;
            diff[2 * limit + 1] -= 2;
            diff[val1 + 1] -= 1;
            diff[val2 + limit + 1] += 1;
            diff[val1 + val2] -= 1;
            diff[val1 + val2 + 1] += 1;
        }

        int sum = 0,res = n;

        for(int i = 2; i <= 2 * limit; i++){

            sum += diff[i];
            res = Math.min(res,sum);
        }

        return res;
    }
}
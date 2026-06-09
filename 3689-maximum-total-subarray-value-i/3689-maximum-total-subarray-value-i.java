class Solution {
    public long maxTotalValue(int[] nums, int k) {
        
        int n = nums.length;

        long maxi = nums[0];
        long mini = nums[0];

        for(int i = 1; i < n; i++){

            maxi = Math.max(maxi,nums[i]);
            mini = Math.min(mini,nums[i]);

        }

        System.out.println(maxi);
        System.out.println(mini);

        return k * (maxi - mini);
    }
}
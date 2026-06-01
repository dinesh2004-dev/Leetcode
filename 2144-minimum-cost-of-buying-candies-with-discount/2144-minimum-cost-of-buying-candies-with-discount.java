class Solution {
    private void reverse(int[] cost){

        int l = 0,r = cost.length - 1;

        while(l <= r){

            int temp = cost[l];
            cost[l] = cost[r];
            cost[r] = temp;

            l++;
            r--;
        }
    }
    public int minimumCost(int[] cost) {
        
        int n = cost.length;
        
        Arrays.sort(cost);

        // reverse(cost);

        int totalCost = 0;

        int free = 0;

        for(int i = n - 1; i >= 0; i--){

            totalCost += cost[i];

            if((n - i) % 3 == 0){

                 free += cost[i];
            }
        }

        return totalCost - free;

        
    }
}
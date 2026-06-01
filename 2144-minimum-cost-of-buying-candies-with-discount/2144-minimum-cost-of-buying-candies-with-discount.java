class Solution {
   
    public int minimumCost(int[] cost) {
        
        int n = cost.length;
        
        Arrays.sort(cost);
        
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
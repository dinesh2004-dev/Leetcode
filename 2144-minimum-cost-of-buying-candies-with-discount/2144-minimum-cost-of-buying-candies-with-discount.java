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

        reverse(cost);

        int totalCost = 0;

        for(int c : cost){

            totalCost += c;
        }

        int free = 0;

        for(int i = 2; i < n; i += 3){

            free += cost[i];
        }

        return totalCost - free;

        
    }
}
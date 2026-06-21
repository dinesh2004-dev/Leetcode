class Solution {
    public int maxIceCream(int[] costs, int coins) {
        
        Arrays.sort(costs);

        int maxIceCreams = 0;
        
        int iceCreamCost = 0;

        for(int cost : costs){

            if(iceCreamCost + cost <= coins){

                iceCreamCost = iceCreamCost + cost;
                maxIceCreams++;
            }
        }

        return maxIceCreams;
    }
}
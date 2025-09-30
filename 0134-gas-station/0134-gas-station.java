class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int totalGas = Arrays.stream(gas).sum();
        int totalCost = Arrays.stream(cost).sum();

        if(totalGas < totalCost){

            return -1;
        }

        int currGas = 0,start = 0;

        for(int i = 0; i < n; i++){

            currGas += gas[i] - cost[i];

            if(currGas < 0){

                currGas = 0;

                start = i + 1;
            }
        }
        return start;
    }
}
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length;

        int gasSum = Arrays.stream(gas).sum();
        int costSum = Arrays.stream(cost).sum();

        if(costSum > gasSum){

            return -1;
        }

        int currGas = 0,startIdx = 0;

        for(int i = 0; i < n; i++){

            currGas += gas[i] - cost[i];

            if(currGas < 0){

                currGas = 0;
                startIdx = i + 1;
            }
        }

        return startIdx;
    }
}
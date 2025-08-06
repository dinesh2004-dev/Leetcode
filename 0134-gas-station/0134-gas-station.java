class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = Arrays.stream(gas).sum();
        int totalCost = Arrays.stream(cost).sum();

        if(totalGas < totalCost){
            return -1;
        }

        int currentGas = 0;
        int start = 0;

        for(int i = 0; i < n; i++){
            currentGas += gas[i] - cost[i];
            if(currentGas < 0){
                currentGas = 0;
                start = i + 1;
            }
        }
        return start;
    }
}
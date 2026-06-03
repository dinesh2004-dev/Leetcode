class Solution {
    private int findEarliestTime(int[] landStartTime,int[] landDuration,int[] waterStartTime,int[] waterDuration){

        int mini = Integer.MAX_VALUE;

        for(int i = 0; i < landStartTime.length; i++){

            mini = Math.min(mini,landStartTime[i] + landDuration[i]);
        }

        int res = Integer.MAX_VALUE;

        for(int i = 0; i < waterStartTime.length; i++){

            res = Math.min(res,
                                
                                Math.max(mini,waterStartTime[i]) + waterDuration[i]);
        }

        return res;
    }
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        return Math.min(
            findEarliestTime(landStartTime,landDuration,waterStartTime,waterDuration),
            findEarliestTime(waterStartTime,waterDuration,landStartTime,landDuration)
        );
        
    }
}
class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        
        int n = landStartTime.length;
        int m = waterStartTime.length;

        int res = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){

            int time = landStartTime[i] + landDuration[i];

            for(int j = 0; j < m; j++){

                if(time >= waterStartTime[j]){

                    time += waterDuration[j];

                    res = Math.min(res,time);

                    time -= waterDuration[j];
                }
                else{

                    int waitTime = waterStartTime[j] - time;

                    time = time + ( waterDuration[j] + waitTime);

                    res = Math.min(res,time);

                    time = time - ( waterDuration[j] + waitTime);
                }
            }
        }

         for(int i = 0; i < m; i++){

            int time = waterStartTime[i] + waterDuration[i];

            for(int j = 0; j < n; j++){

                if(time >= landStartTime[j]){

                    time += landDuration[j];

                    res = Math.min(res,time);

                    time -= landDuration[j];
                }
                else{

                    int waitTime = landStartTime[j] - time;

                    time = time + ( landDuration[j] + waitTime);

                    res = Math.min(res,time);

                    time = time - ( landDuration[j] + waitTime);
                }
            }
        }

        return res;
    }
}
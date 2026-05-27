class Solution {
    private int findNextInterval(int[][] intervals,int k){

        // int n = intervals.length;

        // int val = intervals[k][1];

        // for(int i = 0; i < n; i++){

        //     if(val <= intervals[i][0]){

        //         return i;
        //     }
        // }

        // return -1;

        int val = intervals[k][1];

         int n = intervals.length;

        int low = k + 1,high = n - 1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(intervals[mid][0] >= val){

                high = mid - 1;
            }
            else{

                low = mid + 1;
            }
        }

        return low == n ? -1 : low;
    }
    private int solve(int[][] intervals,int ind,int[] dp){

        if(ind >= intervals.length || ind == -1){

            return 0;
        }

        if(dp[ind] != -1){

            return dp[ind];
        }

        int notPick = solve(intervals,ind + 1,dp);

        int idx = findNextInterval(intervals,ind);
        int pick = intervals[ind][2] + solve(intervals,idx,dp);

        return dp[ind] = Math.max(pick,notPick);
        
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        int n = startTime.length;

        int[] dp = new int[n];

        Arrays.fill(dp,-1);

        int[][] intervals = new int[n][3];

        for(int i = 0; i < n; i++){

            intervals[i][0] = startTime[i];
            intervals[i][1] = endTime[i];
            intervals[i][2] = profit[i];
        }

        Arrays.sort(intervals,(x,y) -> x[0] - y[0]);

       

        return solve(intervals,0,dp);
    }
}
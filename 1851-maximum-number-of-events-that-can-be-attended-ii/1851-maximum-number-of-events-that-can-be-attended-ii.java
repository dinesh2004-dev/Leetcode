class Solution {
    private int[][] dp;
    private int findNextEvent(int endDay,int left,int[][] events){
        int right = events.length - 1;
        int ans = events.length;

        while(left <= right){
            int mid = (left + right) / 2;

            if(events[mid][0] > endDay){
                ans = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return ans;
    }
    public int solve(int i,int[][] events,int k){
        if(i >= events.length || k == 0){
            return 0;
        }
        if(dp[i][k] != -1){
            return dp[i][k];
        }
        int notPick = solve(i + 1,events,k);
        int nextIndex = findNextEvent(events[i][1],i + 1,events);
        int pick = events[i][2] + solve(nextIndex,events,k - 1);
        return dp[i][k] = Math.max(pick,notPick);
    }
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,(a,b) -> a[0] - b[0]);
        dp = new int[events.length][k + 1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return solve(0,events,k);
    }
}
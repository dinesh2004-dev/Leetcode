class Solution {
    private static int mod = 1000000007;
    public int solve(int ind,int prev,String s,boolean[] visited, int[][] dp){
        if(ind >= s.length()){
            return 1;
        }
        if(dp[ind][prev + 1] != -1){
            return dp[ind][prev+1];
        }
        int cnt = 0;
        for(int i = 0; i <= s.length(); i++){
            if(!visited[i]){
                visited[i] = true;

                if(prev == -1){
                    cnt = (cnt + solve(ind,i,s,visited,dp)) % mod;
                }
                else if((s.charAt(ind) == 'D' && i < prev) || s.charAt(ind) == 'I' && i > prev){
                    cnt = (cnt + solve(ind + 1,i,s,visited,dp)) % mod;
                }

                visited[i] = false;
            }
        }
        return dp[ind][prev+1] = cnt;
    }
    public int numPermsDISequence(String s) {
        int n = s.length();
        boolean[] visited = new boolean[n + 2];
        int[][] dp = new int[n][n + 2];
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        return solve(0,-1,s,visited,dp);
    }
}
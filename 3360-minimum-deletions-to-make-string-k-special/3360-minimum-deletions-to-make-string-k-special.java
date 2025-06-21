class Solution {
    public int solve(int i,int j,int[] hash,int[][] dp,int k){
        if(i == j || hash[j] - hash[i] <= k){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        return dp[i][j] = Math.min(hash[i] + solve(i + 1,j,hash,dp,k),
        hash[j] - hash[i] - k + solve(i,j - 1,hash,dp,k));
    }
    public int minimumDeletions(String word, int k) {
        int[] hash = new int[26];
        int[][] dp = new int[26][26];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }

        for(char ch : word.toCharArray()){
            hash[ch - 'a']++;
        }

        Arrays.sort(hash);
        return solve(0,25,hash,dp,k);
    }
}
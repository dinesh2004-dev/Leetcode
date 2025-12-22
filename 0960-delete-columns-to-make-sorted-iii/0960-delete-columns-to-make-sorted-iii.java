class Solution {
    public int solve(int col,int[][] valid,int[] dp){

        if(dp[col] != -1){

            return dp[col];
        }
        int ans = 1;

        for(int prev = 0; prev < col; prev++){

            if(valid[prev][col] == 1){

                ans = Math.max(ans,1 + solve(prev,valid,dp));
            }
        }

        return dp[col] = ans;
    }
    public int minDeletionSize(String[] strs) {
        
        int n = strs.length;
        int m = strs[0].length();

        int[][] isValid = new int[m][m];

        for(int i = 0; i < m; i++){

            for(int j = i + 1; j < m; j++){
                
                boolean valid = true;

                for(int k = 0; k < n; k++){

                    if(strs[k].charAt(i) > strs[k].charAt(j)){

                        valid = false;
                        break;
                    }
                }

                isValid[i][j] = (valid) ? 1 : 0;

            }
        }

        int maxKeep = 0;

        int[] dp = new int[m];

        Arrays.fill(dp,-1);

        for(int i = 0; i < m; i++){

            maxKeep = Math.max(maxKeep,solve(i,isValid,dp));
        }

        return m - maxKeep;
    }
}
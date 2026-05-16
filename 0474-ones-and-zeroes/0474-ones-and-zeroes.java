class Solution {

    private static Map<Integer,int[]> mpp = new HashMap<>();
    private void fillMap(String[] strs){

        int n = strs.length;

        for(int i = 0; i < n; i++){

            String s = strs[i];

            mpp.put(i,countOnesAndZeros(s));
        }
    }
    private int[] countOnesAndZeros(String s){

        int ones = 0,zeros = 0;

        for(char ch : s.toCharArray()){

            if(ch == '1'){

                ones++;
            }
            else{

                zeros++;
            }
        }

        return new int[]{zeros,ones};
    }
    private int solve(int ind,String[] strs,int m,int n,int[][][] dp){

        if(strs.length == ind){

            return 0;
        }

        if(dp[ind][m][n] != -1){

            return dp[ind][m][n];
        }

        int notPick = solve(ind + 1,strs,m,n,dp);

        int[] onesAndZeros = mpp.get(ind);

        int zeros = onesAndZeros[0];
        int ones = onesAndZeros[1];

        int pick = Integer.MIN_VALUE;

        if(m >= zeros && n >= ones){

            pick = 1 + solve(ind + 1,strs,m - zeros,n - ones,dp);

        }

        return dp[ind][m][n] = Math.max(pick,notPick);
      
    }
    public int findMaxForm(String[] strs, int m, int n) {

        int len = strs.length;

        // int[][][] dp = new int[len][m + 1][n + 1];

        // for(int[][] d1 : dp){

        //     for(int[] d2 : d1){

        //         Arrays.fill(d2,-1);
        //     }
        // }
        
        fillMap(strs);
        
        // return solve(0,strs,m,n,dp);

        int[][] dp = new int[m + 1][n + 1];

        for(int ind = len -  1; ind >= 0; ind--){

             int[] onesAndZeros = mpp.get(ind);
             int zeros = onesAndZeros[0];
             int ones = onesAndZeros[1];

            for(int i = m; i >= zeros; i--){

                for(int j = n; j >= ones; j--){

                    int notPick = dp[i][j];

                    int pick = Integer.MIN_VALUE;

                    pick = 1 + dp[i - zeros][j - ones];

                    dp[i][j] = Math.max(pick,notPick);
                }
            }
        }

        return dp[m][n];
    }
}
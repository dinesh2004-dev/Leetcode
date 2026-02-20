class Solution {
    // private void solve(int row,int col,int m,int n,String path,Set<String> set){

    //     if(row > m || row < 1 || col > n || col < 1){

    //         return;
    //     }

    //     if(row == m && col == n){

    //         set.add(path);
    //         return;
    //     }

    //     solve(row + 1,col,m,n,path+"B",set);
    //     solve(row,col + 1,m,n,path+"R",set);

    // }
    public int uniquePaths(int m, int n) {
        
        int dp[][] = new int[m+1][n+1];

        for(int i = m; i > 0; i--){

            for(int j = n; j > 0; j--){

                if(i == m && j == n){

                    dp[i][j] = 1;

                    continue;
                }

                int down = 0,right = 0;

                if(i + 1 <= m){

                    down = dp[i + 1][j];
                }
                if(j + 1 <= n){

                    right = dp[i][j + 1];
                }

                dp[i][j] = down + right;
            }
        }

        return dp[1][1];
    }
}
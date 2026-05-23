class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        
         int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = n - 1; i >= 0; i--){

            for(int j = m - 1; j >= 0; j--){

                if(str1.charAt(i) == str2.charAt(j)){

                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
                else{

                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j + 1]);
                }
            }

        }

        int i = 0, j = 0;
        StringBuilder res = new StringBuilder();

        while(i < n && j < m){

            if(str1.charAt(i) == str2.charAt(j)){

                res.append(str1.charAt(i));
                i++;
                j++;
            }
            else if(dp[i + 1][j] > dp[i][j + 1]){

                res.append(str1.charAt(i));
                i++;
            }
            else{

                res.append(str2.charAt(j));
                j++;
            }
        }

        while(i < n){
            
             res.append(str1.charAt(i));
            i++;
        }

        while(j < m){
            
             res.append(str2.charAt(j));
            j++;
        }

        return res.toString();
        
       
    }
}
class Solution {
    public int findLCS(String s1,String s2,int ind1,int ind2,int[][] dp){

        if(ind1 < 0 || ind2 < 0){

            return 0;
        }
        
        if(dp[ind1][ind2] != -1){

            return dp[ind1][ind2];
        }
        if(s1.charAt(ind1) == s2.charAt(ind2)){

            return s1.charAt(ind1) + findLCS(s1,s2,ind1 - 1,ind2 - 1,dp);
        }

        return dp[ind1][ind2] = Math.max(findLCS(s1,s2,ind1,ind2 - 1,dp),
                        findLCS(s1,s2,ind1 - 1,ind2,dp));
    }
    
    public int minimumDeleteSum(String s1, String s2) {

       int n1 = s1.length();
       int n2 = s2.length();

       int[][] dp = new int[n1][n2];

       for(int[] d : dp){

            Arrays.fill(d,-1);
       }
       
       int lcsSum = findLCS(s1,s2,n1 - 1,n2 - 1,dp);

       int asciiSumOfS1 = 0,asciiSumOfS2 = 0;

        

        for(int i = 0; i < n1; i++){

            asciiSumOfS1 += s1.charAt(i);
        }

         for(int i = 0; i < n2; i++){

            asciiSumOfS2 += s2.charAt(i);
        }

        int res = (asciiSumOfS1 - lcsSum) + (asciiSumOfS2 - lcsSum);

        return res;


    }
}
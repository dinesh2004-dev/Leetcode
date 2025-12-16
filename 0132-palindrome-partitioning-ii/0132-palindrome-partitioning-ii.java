class Solution {
    private boolean isPalindrome(String str,int l,int r){

      
        while(l <= r){

            if(str.charAt(l) != str.charAt(r)){

                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    private int solve(int i,String s,int[] dp){

        if(i == s.length()){

            return 0;
        }

        if(dp[i] != -1){

            return dp[i];
        }

        

        int minCost = Integer.MAX_VALUE;

        for(int j = i; j < s.length(); j++){

          
            if(isPalindrome(s,i,j)){

                int cost = 1 + solve(j + 1,s,dp);
                minCost = Math.min(cost,minCost);
            }
        }

        return dp[i] = minCost;
    }
    int minCut(String s) {
        //your code goes here

        int dp[] = new int[s.length()];

        Arrays.fill(dp,-1);

        return solve(0,s,dp) - 1;
    }
}
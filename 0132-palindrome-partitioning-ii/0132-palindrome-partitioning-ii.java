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
    private int memoize(int i,String s,int[] dp){

        if(i == s.length()){

            return 0;
        }

        if(dp[i] != -1){

            return dp[i];
        }

        

        int minCost = Integer.MAX_VALUE;

        for(int j = i; j < s.length(); j++){

          
            if(isPalindrome(s,i,j)){

                int cost = 1 + memoize(j + 1,s,dp);
                minCost = Math.min(cost,minCost);
            }
        }

        return dp[i] = minCost;
    }
    private int tabulation(String s){

        int n = s.length();

        int[] dp = new int[n + 1];

        dp[n] = 0;

        for(int i = n - 1; i >= 0; i--){

            int minCost = Integer.MAX_VALUE;

            for(int j = i; j < n; j++){

                if(isPalindrome(s,i,j)){

                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(minCost,cost);
                }
            }

            dp[i] = minCost;
        }

        return dp[0];

    }
    int minCut(String s) {
        //your code goes here

        int dp[] = new int[s.length()];

        Arrays.fill(dp,-1);

        // return memoize(0,s,dp) - 1;

        return tabulation(s) - 1;
    }
}
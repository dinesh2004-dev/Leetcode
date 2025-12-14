class Solution {
    public boolean checkAllStars(String str,int len){

        while(len >= 0){

            if(str.charAt(len) == '*'){

                len = len - 2;
            }
            else{

                return false;
            }
        }

        return true;
    }
    public boolean solve(String s,String p,int ind1,int ind2,boolean[][] dp){

        if(ind1 < 0 && ind2 < 0){

            return true;
        }

        if(ind1 >= 0 && ind2 < 0){

            return false;
        }
        if(ind1 < 0 && ind2 >= 0){

            return checkAllStars(p,ind2);
        }

        if(dp[ind1][ind2]){

            return dp[ind1][ind2];
        }

        if(s.charAt(ind1) == p.charAt(ind2) || p.charAt(ind2) == '.'){

            return dp[ind1][ind2] = solve(s,p,ind1 - 1,ind2 - 1,dp);
        }
        if(p.charAt(ind2) == '*'){

            boolean zero = solve(s,p,ind1,ind2 - 2,dp);

            boolean multiple = false;

            if(p.charAt(ind2 - 1) == s.charAt(ind1) || p.charAt(ind2 - 1) == '.'){
                multiple = solve(s,p,ind1 - 1,ind2,dp);
            }

            return dp[ind1][ind2] = zero || multiple;
        }

        return dp[ind1][ind2] = false;
    }
    public boolean isMatch(String s, String p) {
        
        int n1 = s.length() - 1;
        int n2 = p.length() - 1;

        boolean[][] dp = new boolean[n1+1][n2+1];

        return solve(s,p,n1,n2,dp);
    }
}
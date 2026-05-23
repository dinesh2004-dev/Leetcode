class Solution {
    private boolean solve(String s,int left,int right){

        while(left <= right){

            if(s.charAt(left) != s.charAt(right)){

                return false;
            }

            left++;
            right--;
        }

        return true;
    }
    public String longestPalindrome(String s) {
        
        int n = s.length();

        int startIdx = -1;
        int maxLen = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){

            for(int j = i; j < n; j++){

                if(j - i + 1 > maxLen && solve(s,i,j)){

                    startIdx = i;
                    maxLen = j - i + 1;
                }
            }
        }

        return s.substring(startIdx,maxLen + startIdx);
    }
}
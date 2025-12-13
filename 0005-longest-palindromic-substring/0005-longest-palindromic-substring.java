class Solution {
    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
    public String longestPalindrome(String s) {

        int n = s.length();

        int maxLen = 1;
        String maxStr = s.substring(0,1);

        for(int i = 0; i < n; i++){

            for(int j = i + 1; j <= n; j++){

                if(j - i > maxLen && isPalindrome(s.substring(i,j))){

                    maxLen = j - i;
                    maxStr = s.substring(i,j);
                }
            }
        }

        return maxStr;
        
    }
}
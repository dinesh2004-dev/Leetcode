class Solution {
    private boolean isPalindrome(String s,int left,int right){

        while(left <= right){

            if(s.charAt(left) != s.charAt(right)){

                return false;
            }

            left++;
            right--;
        }

        return true;
    }
    public int countSubstrings(String s) {
        
        int n = s.length();
        int cnt = 0;

        for(int i = 0; i < n; i++){

            for(int j = i; j < n; j++){

                if(isPalindrome(s,i,j)){

                    cnt++;
                }
            }
        }

        return cnt;
    }
}
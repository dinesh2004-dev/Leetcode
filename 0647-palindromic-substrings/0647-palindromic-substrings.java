class Solution {
    public boolean isPalindrome(String s,int l,int h){

        while(l <= h){

            if(s.charAt(l) != s.charAt(h)){

                return false;
            }

            l++;
            h--;
        }

        return true;
    }
    public int countSubstrings(String s) {

        int n = s.length();

        int count = 0;

        for(int i = 0; i < n; i++){

            for(int j = i; j < n; j++){

                if(isPalindrome(s,i,j)){

                    count++;
                }
            }
        }

        return count;
        
    }
}
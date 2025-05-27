class Solution {
    public int[] computeLPS(String s){
        int n = s.length();

        int[] lps = new int[n];

        int i = 1,j = 0;

        while(i < n){

            if(s.charAt(i) == s.charAt(j)){

                lps[i] = j + 1;
                j++;
                i++;

            }
            else{

                while(j > 0 && s.charAt(i) != s.charAt(j)){
                    j = lps[j - 1];
                }
                if(s.charAt(i) == s.charAt(j)){
                    lps[i] = j + 1;

                    j++;
                }
                i++;
            }
        }

        return lps;
    }
    public String shortestPalindrome(String s) {
        int n = s.length();

        StringBuilder revs = new StringBuilder(s);

        revs.reverse();

        String str = s+"$"+revs;

        int[] lps = computeLPS(str);

        int ans = s.length() - lps[lps.length - 1];

        String toadd = revs.substring(0,ans);

        return toadd+s;
    }
}

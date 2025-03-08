class Solution {

    public int[] findKmp(String s){

        int[] kmp = new int[s.length()];

        int i = 1,j = 0;

        while(i < s.length()){

            if(s.charAt(i) == s.charAt(j)){

                kmp[i] = j + 1;

                i++;

                j++;
            }
            else{

                while(j > 0 && s.charAt(i) != s.charAt(j)){

                    j = kmp[j - 1];
                }
                if(s.charAt(i) == s.charAt(j)){

                    kmp[i] = j + 1;

                    j++;
                }
                i++;
            }
        }
        return kmp;
    }
    public String shortestPalindrome(String s) {
        
        StringBuilder revs = new StringBuilder(s);

        String str = s + '$' + revs.reverse();

        int[] kmp = findKmp(str);

        int ans = s.length() - kmp[kmp.length - 1];

        String toAdd = revs.substring(0,ans);

        return toAdd + s;
    }
}

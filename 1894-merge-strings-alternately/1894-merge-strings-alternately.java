class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int n1 = word1.length(),n2 = word2.length();

        int i = 0 , j = 0;

        String res = "";

        while(i  < n1 && j < n2){

            res = res + word1.charAt(i);

            res = res + word2.charAt(j);

            i++;

            j++;
        }

        while(i < n1){
            res = res + word1.charAt(i);

            i++;
        }

         while(j < n2){
            res = res + word2.charAt(j);

            j++;
        }
        return res;
    }
}
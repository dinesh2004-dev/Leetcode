class Solution {
    public String reverseVowels(String s) {
        
        int i = 0,j = s.length() - 1;

       

        char str[] = s.toCharArray();

        String vowels = "aeiouAEIOU";

        while(i < j){

            while(i < j && vowels.indexOf(str[i]) == -1){
                i++;
            }
             while(i < j && vowels.indexOf(str[j]) == -1){
                j--;
            }
            char temp = str[i];

            str[i] = str[j];

            str[j] = temp;

            i++;
            j--;
        }

        return new String(str);
    }
}
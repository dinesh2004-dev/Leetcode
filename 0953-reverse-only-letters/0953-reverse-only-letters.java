class Solution {
    public String reverseOnlyLetters(String s) {
        int i = 0,j = s.length() - 1;
        char[] chars = s.toCharArray();
        while(i <= j){
            if(!Character.isLetter(chars[i])){
                i++;
            }
            else if(!Character.isLetter(chars[j])){
                j--;
            }
            else{
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }
        return new String(chars);
    }
}
class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3){
            return false;
        }
        char[] chars = word.toCharArray();
        int vowel = 0,consonant = 0;
        String vowels = "aeiou";
        for(char ch : chars){
           if(!Character.isLetterOrDigit(ch)){
                return false;
           }
           char c = Character.toLowerCase(ch);
           if(Character.isDigit(c)){
                continue;
           }
           else if(vowels.indexOf(c) != - 1){
                vowel++;
           }
           else{
                consonant++;
           }

        }
        return (vowel >= 1 && consonant >= 1) ? true : false;
    }
}
class Solution {

    public boolean isVowel(char c){

        return "aeiou".indexOf(c) != -1;
    }
    public int maxVowels(String s, int k) {
        
        char[] chars = s.toCharArray();

        int n = chars.length, i = 0, j = 0;

        int vowels = 0 ,maxVowels = Integer.MIN_VALUE;

        while(j < n){
            if(isVowel(chars[j])){
                vowels++;
            }

            while((j - i + 1) == k){

                maxVowels = Math.max(maxVowels,vowels);

                if(isVowel(chars[i])){

                    vowels--;
                }

                i++;
            }
            j++;
        }
        return maxVowels;
    }
}
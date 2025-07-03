class Solution {
    public char kthCharacter(int k) {
        String word = "a";
        while(true){
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < word.length(); i++){
                int ch = word.charAt(i) % 97;
                str.append((char)(97 + ch + 1));
            }
            word = word + str.toString();
            if(word.length() >= k){
                break;
            }
        }
        return word.charAt(k - 1);
    }

}
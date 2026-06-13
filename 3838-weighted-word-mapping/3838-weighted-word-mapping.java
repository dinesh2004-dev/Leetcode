class Solution {
    public String mapWordWeights(String[] words, int[] weights) {

        int sum = 0;
        StringBuilder str = new StringBuilder();

        for(String word : words){
            int currSum = 0;
            for(char ch : word.toCharArray()){

                currSum += weights[ch - 'a'];
            }

            int modVal = currSum % 26;

            str.append((char) ('a' + (26 - modVal - 1)));
        }

        return str.toString();
    }
}
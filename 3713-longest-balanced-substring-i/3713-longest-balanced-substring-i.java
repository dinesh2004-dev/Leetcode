class Solution {
    public int longestBalanced(String s) {
        
        int n = s.length();

        int maxLen = 0;

        for(int l = 0;l < n; l++){

            int[] hash = new int[26];
            int maxFreq = 0,maxCnt = 0,unq = 0;

            for(int r = l; r < n; r++){

                hash[s.charAt(r) - 'a']++;

                int currFreq = hash[s.charAt(r) - 'a'];

                unq += (currFreq == 1) ? 1 : 0;

                if(currFreq > maxFreq){

                    maxFreq = currFreq;
                    maxCnt = 1;
                }
                else if(maxFreq == currFreq){

                    maxCnt++;
                }

                if(maxCnt == unq){

                    maxLen = Math.max(maxLen,r - l + 1);
                }
  
            }
        }

        return maxLen;
        
    }
}
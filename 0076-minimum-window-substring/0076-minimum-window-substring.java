class Solution {
    public String minWindow(String s, String t) {
       
        int l = 0,r = 0,start = -1,minLen = Integer.MAX_VALUE;

        int n = s.length();

        int count = 0;

        int[] hash = new int[256];

        for(char c:t.toCharArray()){

            hash[c]++;
        }

        while(r < n){

            char ch = s.charAt(r);

            if(hash[ch] > 0){

                count++;
                
            }

            hash[ch]--;

            while(count == t.length()){

                if((r - l + 1) < minLen){

                    minLen = r - l + 1;
                    start = l;
                }

                
                ch = s.charAt(l);

                hash[ch]++;

                if(hash[ch] > 0){

                    count--;
                }

                l++;

            }

            r++;
        }

        return start == -1 ? "" : s.substring(start,start + minLen);
    }
}
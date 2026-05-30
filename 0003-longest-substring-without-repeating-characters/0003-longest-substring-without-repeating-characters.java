class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();

        Map<Character,Integer> mpp = new HashMap<>();

        int left = 0,right = 0;

        int maxLen = 0;

        while(right < n){

            mpp.put(s.charAt(right),mpp.getOrDefault(s.charAt(right),0) + 1);

            while((right - left + 1) > mpp.size()){

                mpp.put(s.charAt(left),mpp.get(s.charAt(left)) - 1);

                if(mpp.get(s.charAt(left)) == 0){

                    mpp.remove(s.charAt(left));
                }

                left++;
            }

            maxLen = Math.max(maxLen,right - left + 1);

            right++;


        }

        return maxLen;
    }
}
class Solution {
    public int largestAltitude(int[] gain) {
        
        int prefix = 0;

        int maxHeight = 0;

        for(int i = 0; i < gain.length; i++){

            prefix = prefix + gain[i];
            maxHeight = Math.max(maxHeight,prefix);
        }

        return maxHeight;
    }
}
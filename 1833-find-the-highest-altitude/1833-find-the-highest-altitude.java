class Solution {
    public int largestAltitude(int[] gain) {

        int maxAltitute = 0;

        int currentAltitude = 0;

        for(int i = 0; i < gain.length; i++){

            currentAltitude += gain[i];

            maxAltitute = Math.max(maxAltitute,currentAltitude);
        }
        return maxAltitute;
        
    }
}
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        Arrays.sort(boxTypes,(x,y) -> y[1] - x[1]);

        int ans = 0;

        for(int[] unit : boxTypes){

            int cnt = Math.min(unit[0],truckSize);
            ans += cnt * unit[1];
            truckSize -= cnt;

            if(truckSize <= 0){

                return ans;
            }
        }
        return ans;
    }
}
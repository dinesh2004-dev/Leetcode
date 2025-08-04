class Solution {
    public int totalFruit(int[] fruits) {
         int n = fruits.length;

        int r = 0,l = 0;

        int maxLen = Integer.MIN_VALUE;

        Map<Integer,Integer> mpp = new HashMap<>();

        while(r < n){

            mpp.put(fruits[r],mpp.getOrDefault(fruits[r],0) + 1);

            if( mpp.size() > 2){

                mpp.put(fruits[l],mpp.getOrDefault(fruits[l],0) - 1);

                if(mpp.get(fruits[l]) == 0){
                    mpp.remove(fruits[l]);
                }

                l++;
            }
            if( mpp.size() <= 2){
                
                maxLen = Math.max(maxLen,r - l + 1);
            }

            r++;
        }
        return maxLen;
    }
}
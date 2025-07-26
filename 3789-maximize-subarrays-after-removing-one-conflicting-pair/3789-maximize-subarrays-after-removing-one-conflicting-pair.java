class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        List<List<Integer>> conflictingPoints = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            conflictingPoints.add(new ArrayList<>());
        }
        
        for(int[] ele : conflictingPairs){
            int a = Math.max(ele[0],ele[1]);
            int b = Math.min(ele[0],ele[1]);
            conflictingPoints.get(a).add(b);
        }
        

        long valid = 0;
        int firstMaxConflict = 0,secondMaxConflict = 0;
        long[] extra = new long[n + 1];

        for(int i = 1; i <= n; i++){

            for(int u : conflictingPoints.get(i)){

                if(u >= firstMaxConflict){
                    secondMaxConflict = firstMaxConflict;
                    firstMaxConflict = u;
                }
                else if(u > secondMaxConflict){
                    secondMaxConflict = u;
                }
            }
            valid += i - firstMaxConflict;
            extra[firstMaxConflict] += firstMaxConflict - secondMaxConflict;
        }
        return valid + Arrays.stream(extra).max().getAsLong();
    }
}
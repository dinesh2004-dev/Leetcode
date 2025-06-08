class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        
        int n = x.length;

        Map<Integer,Integer> mpp = new HashMap<>();

        for(int i = 0; i < n; i++){

            mpp.put(x[i],Math.max(mpp.getOrDefault(x[i],0),y[i]));
        }

        if(mpp.size() < 3){
            return -1;
        }

        ArrayList<Integer> list = new ArrayList<>(mpp.values());
        list.sort(Collections.reverseOrder());

        return list.get(0)+list.get(1)+list.get(2);
        
    }
}
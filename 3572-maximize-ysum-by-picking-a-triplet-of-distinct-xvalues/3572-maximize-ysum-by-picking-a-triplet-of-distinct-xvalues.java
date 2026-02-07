class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        
        HashMap<Integer,Integer> mpp = new HashMap<>();

        for(int i = 0; i < x.length; i++){

            mpp.put(x[i],Math.max(mpp.getOrDefault(x[i],0),y[i]));
        }

        if(mpp.size() < 3){

            return -1;
        }

        List<Integer> list = new ArrayList<>(mpp.values());

        list.sort(Collections.reverseOrder());

        return list.get(0) + list.get(1) + list.get(2);

        
    }
}
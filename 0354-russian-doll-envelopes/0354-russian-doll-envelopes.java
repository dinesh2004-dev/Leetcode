class Solution {
    private int binarySearch(List<Integer> list,int key){

       int low = 0,high = list.size() - 1;

       while(low <= high){

            int mid = low + (high - low) / 2;

            

            if(key > list.get(mid)){

                low = mid + 1;
            }
            else{

                high = mid - 1;
            }
       }

       return low;
        
    }
    public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort(envelopes,(x,y) -> {

            if(x[0] == y[0]){

                return y[1] - x[1];
            }

            return x[0] - y[0];
        });

        int n = envelopes.length;

        List<Integer> list = new ArrayList<>();

        list.add(envelopes[0][1]);

        for(int i = 1; i < n; i++){

            

            if(list.get(list.size() - 1) < envelopes[i][1]){

                list.add(envelopes[i][1]);
            }
            else{

                int idx = binarySearch(list,envelopes[i][1]);

                list.set(idx,envelopes[i][1]);
            }
        }

        return list.size();
        
       
    }
}
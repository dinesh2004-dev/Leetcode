class Solution {
    public int binarySearch(int[] arr,long x,int val){

        int low = 0,high = arr.length - 1;

        while(low <= high){

            int mid = (low + high) / 2;

            long res = (long) val * arr[mid];

            if(res >= x){
                high = mid - 1;
            }
            else{

                low = mid + 1;
            }
        }

        return low;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

            int n = spells.length;
            int m = potions.length;

            ArrayList<Integer> list = new ArrayList<>(Collections.nCopies(n,0));

            Arrays.sort(potions);

            for(int i = 0; i < n; i++){

                int idx = binarySearch(potions,success,spells[i]);

                list.set(i,m - idx);
                
            }

            int[] res = list.stream()
                            .mapToInt(Integer::intValue)
                            .toArray();
            
            return res;
    }
}
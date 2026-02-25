class Solution {
    private int countSetBits(int num){

        int count = 0;

        while(num != 0){

            num = num & (num - 1);
            count++;
        }

        return count;
    }
    public int[] sortByBits(int[] arr) {
        
        List<List<Integer>> temp = new ArrayList<>();

        int n = arr.length;

        for(int i = 0; i < n; i++){

            int noOfSetBits = countSetBits(arr[i]);

            temp.add(new ArrayList<>(Arrays.asList(noOfSetBits,arr[i])));
        }

        Collections.sort(temp,(x,y) -> {

            if(x.get(0) == y.get(0)){

                return Integer.compare(x.get(1),y.get(1));
            }

            return Integer.compare(x.get(0),y.get(0));
        });

        int[] res = new int[temp.size()];

        for(int i = 0; i < temp.size(); i++){

            res[i] = temp.get(i).get(1);
        }

        return res;
    }
}
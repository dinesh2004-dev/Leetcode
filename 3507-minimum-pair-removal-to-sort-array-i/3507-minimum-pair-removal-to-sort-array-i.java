class Solution {
    public int minimumPairRemoval(int[] nums) {
        
        List<Integer> res = new ArrayList<>();

        int n = nums.length;

        for(int num : nums){

            res.add(num);
        }

        int ops = 0;

        while(true){

            boolean isSorted = true;

            for(int i = 0; i < res.size() - 1; i++){

                if(res.get(i) > res.get(i + 1)){

                    isSorted = false;
                    break;
                }
            }

            if(isSorted){

                return ops;
            }

            int minSum = Integer.MAX_VALUE;
            int index = -1;

            for(int i = 0; i < res.size() - 1; i++){

                int sum = res.get(i) + res.get(i + 1);

                if(sum < minSum){

                    minSum = sum;
                    index = i;
                }
            }

            res.set(index,minSum);
            res.remove(index + 1);

            ops++;
        }
        
    }
}
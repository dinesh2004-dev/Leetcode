class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        
        int n = nums.length;

        Map<Integer,List<Integer>> mpp = new HashMap<>();

        for(int i = 0; i < n; i++){

            if(!mpp.containsKey(nums[i])){

                mpp.put(nums[i],new ArrayList<>());
            }

            List<Integer> list = mpp.get(nums[i]);

            list.add(i);
        }

        List<Integer> res = new ArrayList<>();

        for(int q : queries){

            int num = nums[q];

            List<Integer> list = mpp.get(num);

            if(list.size() == 1){

                res.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(list,q);

            int min = Integer.MAX_VALUE;

            int left = (pos > 0) ? list.get(pos - 1) : list.get(list.size() - 1);
            int d1 = Math.abs(q - left);

            min = Math.min(min,Math.min(d1,n - d1));

            int right = (pos < list.size() - 1) ? list.get(pos + 1) : list.get(0);
            int d2 = Math.abs(q - right);

            min = Math.min(min,Math.min(d2,n - d2));

            res.add(min);
        }

        return res;
    }
}
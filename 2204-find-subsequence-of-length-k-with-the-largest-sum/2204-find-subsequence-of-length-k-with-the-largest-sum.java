class Solution {
    static class Pair{
        int key;
        int idx;
        public Pair(int key,int idx){
            this.key = key;
            this.idx = idx;
        }
        public int getKey(){
            return key;
        }
        public int getIdx(){
            return idx;
        }
        
    }
    public int[] maxSubsequence(int[] nums, int k) {
        Pair[] pairs = new Pair[nums.length];
        for(int i = 0; i < nums.length; i++){
                Pair pair = new Pair(nums[i],i);
                pairs[i] = pair;
            }

             Arrays.sort(pairs,(a,b) -> b.getKey() - a.getKey());
            Arrays.sort(pairs,0,k,(a,b) -> a.getIdx() - b.getIdx());
           
           int[] res = new int[k];
           for(int i = 0; i < k; i++){
               res[i] = pairs[i].getKey();
           }

           return res;
        
    }
}
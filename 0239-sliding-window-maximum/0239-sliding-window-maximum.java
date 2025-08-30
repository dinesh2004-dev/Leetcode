class Solution {
    class Pair{
        int val;
        int idx;
        public Pair(int val,int idx){
            this.val = val;
            this.idx = idx;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.val - a.val);

        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Pair pair = new Pair(nums[i],i);
            
            pq.add(pair);

            while(pq.peek().idx <= i - k){
                pq.poll();
            }

            if(i >= k - 1){
                res.add(pq.peek().val);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
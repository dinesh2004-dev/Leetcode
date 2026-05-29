class Pair{

    int val;
    int idx;

    public Pair(int val,int idx){

        this.val = val;
        this.idx = idx;
    }
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;

        List<Integer> temp = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> y.val - x.val);

        for(int i = 0; i < n; i++){

            Pair pair = new Pair(nums[i],i);

            pq.add(pair);

            while(pq.peek().idx <= i - k){

                pq.poll();
            }

            if(i >= k-1){

                temp.add(pq.peek().val);
            }
        }

        return temp.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}
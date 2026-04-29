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

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> y.val - x.val);

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){

            pq.add(new Pair(nums[i],i));

            while(pq.peek().idx <= i - k){

                pq.poll();
            }

            if(i >= k - 1){

                list.add(pq.peek().val);
            }
        }

        return list.stream()
                    .mapToInt(Integer :: intValue)
                    .toArray();
    }
}
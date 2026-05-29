class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;

        List<Integer> temp = new ArrayList<>();

        Deque<Integer> dq = new LinkedList<>();

        for(int i = 0; i < n; i++){

            if(!dq.isEmpty() && dq.peekFirst() <= (i - k)){

                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){

                dq.pollLast();
            }

            dq.offerLast(i);

            if(i >= k - 1){

                temp.add(nums[dq.peekFirst()]);
            }

        }

        return temp.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}
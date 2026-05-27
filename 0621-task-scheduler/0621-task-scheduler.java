class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] hash = new int[26];

        for(char ch : tasks){

            hash[ch - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int h : hash){

            if(h > 0){

                pq.add(h);
            }
        }

        int intervals = 0;

        while(!pq.isEmpty()){

            List<Integer> temp = new ArrayList<>();
            int taskCount = 0;
            int cycle = n  + 1;

            for(int i = 0; i < cycle; i++){

                if(!pq.isEmpty()){

                    temp.add(pq.poll() - 1);
                    taskCount++;
                }
            }

            for(int ele : temp){

                if(ele > 0){

                    pq.add(ele);
                }
            }

            intervals += (pq.isEmpty()) ? taskCount : cycle;
        }

        return intervals;
    }
}
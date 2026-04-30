class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] hash = new int[26];

        for(char ch : tasks){

            hash[ch -'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int key : hash){

            if(key > 0){

                pq.add(key);
            }
        }

        int time = 0;

        while(!pq.isEmpty()){

            List<Integer> temp = new ArrayList<>();
            int taskCount = 0;
            int cycle = n + 1;

            for(int i = 0; i < cycle; i++){

                if(!pq.isEmpty()){

                    temp.add(pq.poll() - 1);
                    taskCount++;
                }
            }

            for(int rem : temp){

                if(rem > 0){

                    pq.add(rem);
                }
            }

            time += pq.isEmpty() ? taskCount : cycle;
        }

        return time;
    }
}
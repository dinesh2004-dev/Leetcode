class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){

            adj.add(new ArrayList<>());
        }

        for(int[] meeting : meetings){

            int x = meeting[0];
            int y = meeting[1];
            int cost = meeting[2];

            adj.get(x).add(new int[]{y,cost});
            adj.get(y).add(new int[]{x,cost});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> x[0] - y[0]);

        List<Integer> res = new ArrayList<>();

        
        pq.add(new int[]{0,0});
        pq.add(new int[]{0,firstPerson});

        Set<Integer> set = new HashSet<>();

        while(!pq.isEmpty()){

            int[] peek = pq.poll();

            int person = peek[1];
            int time = peek[0];

            if(set.contains(person)){

                continue;
            }
            else{

                set.add(person);
                res.add(person);
            }

            for(int[] neighbour : adj.get(person)){

                int currPerson = neighbour[0];
                int currTime = neighbour[1];
                if(currTime < time){
                    continue;
                }
                pq.add(new int[]{currTime,currPerson});
            }

        }

        return res;
        
    }
}
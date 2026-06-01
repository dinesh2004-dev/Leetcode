class Solution {
    private List<List<Integer>> constructAdjList(int[][] edges,int n){


        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){

            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        return adj;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = constructAdjList(prerequisites,numCourses);
        
        int[] inDegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){

            for(int node : adj.get(i)){

                inDegree[node]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){

            if(inDegree[i] == 0){

                q.add(i);
            }
        }

        // List<Integer> temp = new ArrayList<>();

        int cnt = 0;

        while(!q.isEmpty()){

            int node = q.poll();

            // temp.add(node);
            cnt++;

            for(int neighbour : adj.get(node)){

                inDegree[neighbour]--;

                if(inDegree[neighbour] == 0){

                    q.add(neighbour);
                }
            }
        }

        return cnt == numCourses;
        
    }
}
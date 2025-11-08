class Solution {
    public List<List<Integer>> constructAdjacencyList(int v,int[][] edges){

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < v; i++){

            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){

            adj.get(edge[0]).add(edge[1]);
        }

        return adj;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = constructAdjacencyList(numCourses,prerequisites);

        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){

            for(int node : adj.get(i)){

                indegree[node]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){

            if(indegree[i] == 0){

                q.add(i);
            }
        }

        int processedNodes = 0;

        while(!q.isEmpty()){

            int node = q.poll();

            processedNodes++;

            for(int neighbours : adj.get(node)){

                indegree[neighbours]--;

                if(indegree[neighbours] == 0){

                    q.add(neighbours);
                }
            }
        }

        return (processedNodes == numCourses) ? true : false;
        
    }
}
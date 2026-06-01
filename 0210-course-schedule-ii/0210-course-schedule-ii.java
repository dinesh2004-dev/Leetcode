class Solution {
    private List<List<Integer>> constructAdjList(int[][] edges,int n){

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){

            adj.add(new ArrayList<>());
        }

        for(int edge[] : edges){

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        return adj;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
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

        List<Integer> temp = new ArrayList<>();

        while(!q.isEmpty()){

            int top = q.poll();

            temp.add(top);

            for(int node : adj.get(top)){

                inDegree[node]--;

                if(inDegree[node] == 0){

                    q.add(node);
                }
            }
        }

         if(temp.size() < numCourses){

            return new int[]{};
        }

        int[] res = new int[numCourses];

        for(int i = 0; i < numCourses; i++){

            res[i] = temp.get(numCourses - i - 1);
        }

        return res;
    }
}
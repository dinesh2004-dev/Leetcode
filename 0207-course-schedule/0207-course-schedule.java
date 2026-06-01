class Solution {
   private boolean dfs(int node,List<List<Integer>> adj,boolean[] visited,boolean[] pathVisited){

        visited[node] = true;
        pathVisited[node] = true;

        for(int neighbours : adj.get(node)){

             if(pathVisited[neighbours]){

                return true;
            }

            if(!visited[neighbours]){

                if(dfs(neighbours,adj,visited,pathVisited)){

                    return true;
                }
               
            }
           
        }

        pathVisited[node] = false;

        return false;
    }
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

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){

            if(!visited[i]){

                if(dfs(i,adj,visited,pathVisited)){

                    return false;
                }
            }
        }

        return true;
    }
}
class Solution {
    public void dfs(int node,List<List<Integer>> adj,boolean[] visited){

        visited[node] = true;

        for(int neighbours : adj.get(node)){

            if(!visited[neighbours]){

                dfs(neighbours,adj,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjList = new ArrayList<>();

        int v = isConnected.length;

       

        for(int i = 0; i < isConnected.length; i++){
            adjList.add(new ArrayList<>());
          for(int j = 0; j < isConnected[i].length; j++){

              if(isConnected[i][j] == 1){

                  adjList.get(i).add(j);
              }

          }
        }

        boolean[] visited = new boolean[v];
        int noOfProvinces = 0;

        for(int i = 0; i < v; i++){

            if(!visited[i]){
                dfs(i,adjList,visited);
                noOfProvinces++;
            }
        }

        return noOfProvinces;
    }
}
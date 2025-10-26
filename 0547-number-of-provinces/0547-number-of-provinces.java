class Solution {
    public void dfs(int node,int[][] isConnected,boolean[] visited){

        visited[node] = true;
        int[] adj = isConnected[node];

        for(int i = 0; i < adj.length; i++){

            if(!visited[i] && adj[i] == 1){

                dfs(i,isConnected,visited);
            }
        }

        
    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjList = new ArrayList<>();

        int v = isConnected.length;

        boolean[] visited = new boolean[v];
        int noOfProvinces = 0;

        for(int i = 0; i < v; i++){

            if(!visited[i]){
                dfs(i,isConnected,visited);
                noOfProvinces++;
            }
        }

        return noOfProvinces;
    }
}
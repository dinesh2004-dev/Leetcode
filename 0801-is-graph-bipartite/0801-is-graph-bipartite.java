class Solution {
    public boolean bfs(int start,int V,int[][] adj,
        int[] colors){

            Queue<Integer> q = new LinkedList<>();

        q.add(start);
       
        colors[start] = 1;

        while(!q.isEmpty()){

            int node = q.poll();

            for(int neighbor : adj[node]){

                if(colors[neighbor] == -1){

                    colors[neighbor] = (colors[node] == 1) ? 0 : 1;
                    q.add(neighbor);
                }
                else if(colors[node] == colors[neighbor]){

                    return false;
                }
            }
        }
        return true;
        }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] colors = new int[V];
        Arrays.fill(colors,-1);

        for(int i = 0; i < V;i++){

            if(colors[i] == -1){

                if(!bfs(i,V,graph,colors)){

                    return false;
                }
            }
        }

        return true;
    }
}
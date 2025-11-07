class Solution {
    public List<List<Integer>> reverseEdges(int v,int[][] graph){

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < v; i++){

            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < v; i++){

            for(int node : graph[i]){

                adj.get(node).add(i);
            }
        }

        return adj;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int v = graph.length;

        List<List<Integer>> adj = reverseEdges(v,graph);

        int[] inDegree = new int[v];

        for(int i = 0; i < v; i++){
            
            for(int node : adj.get(i)){

                inDegree[node]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < v; i++){

            if(inDegree[i] == 0){

                q.add(i);
            }
        }

        List<Integer> res = new ArrayList<>();

        while(!q.isEmpty()){

            int node = q.poll();
            res.add(node);

            for(int neighbour : adj.get(node)){

                inDegree[neighbour]--;

                if(inDegree[neighbour] == 0){

                    q.add(neighbour);
                }
            }
        }

        Collections.sort(res);

        return res;
    }
}
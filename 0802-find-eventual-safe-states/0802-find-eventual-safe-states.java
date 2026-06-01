class Solution {
    private List<List<Integer>> constructAdjList(int[][] graph){

        int n = graph.length;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){

            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){

            for(int edge : graph[i]){

                adj.get(edge).add(i);
            }
        }

        return adj;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<List<Integer>> adj = constructAdjList(graph);

        int n = graph.length;

        int[] indegree = new int[n];

        for(int i = 0; i < n; i++){

            for(int node : adj.get(i)){

                indegree[node]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < n; i++){

            if(indegree[i] == 0){

                q.add(i);
            }
        }

        while(!q.isEmpty()){

            int top = q.poll();

            res.add(top);

            for(int node : adj.get(top)){

                indegree[node]--;

                if(indegree[node] == 0){

                    q.add(node);
                }
            }
        }

        Collections.sort(res);

        return res;
    }
}
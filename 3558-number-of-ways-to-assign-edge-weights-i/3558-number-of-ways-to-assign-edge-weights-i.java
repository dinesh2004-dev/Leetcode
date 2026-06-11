class Solution {

    private static int MOD = (int) 1e9+7;
    
    private int dfs(int node,int parent,Map<Integer,List<Integer>> adj){

        int depth = 0;
        for(int neighbour : adj.getOrDefault(node,new ArrayList<>())){

            if(neighbour != parent){

                depth = Math.max(depth,1 + dfs(neighbour,node,adj));
            }
        }

        return depth;

    }
    private long modPow(long base, int exp) {

        long ans = 1;

        while (exp > 0) {

            if ((exp & 1) == 1) {
                ans = (ans * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return ans;
    }
    // private long pow(long base,int exp){

    //     if(exp == 0){

    //         return 1;
    //     }

    //     if(exp % 2 == 0){

    //         return (pow(base * base,exp / 2) % MOD);
    //     }

    //     return (base * pow(base,exp - 1)) % MOD;
    // }
    public int assignEdgeWeights(int[][] edges) {
        
        Map<Integer,List<Integer>> adj = new HashMap<>();

        for(int[] edge : edges){

            int u = edge[0];
            int v = edge[1];

            if(!adj.containsKey(u)){

                adj.put(u,new ArrayList<>());
            }
             if(!adj.containsKey(v)){

                adj.put(v,new ArrayList<>());
            }

            adj.get(u).add(v);
            adj.get(v).add(u);

            
        }

        int depth = dfs(1,-1,adj);

        return (int) modPow(2,depth - 1);
    }
}
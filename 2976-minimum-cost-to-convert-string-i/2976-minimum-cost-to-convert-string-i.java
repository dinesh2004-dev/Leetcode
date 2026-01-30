class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        
        int[][] adj = new int[26][26];

        for(int i = 0; i < 26; i++){

            Arrays.fill(adj[i],Integer.MAX_VALUE);
            adj[i][i] = 0;
        }

        for(int i = 0; i < original.length; i++){

            int u = original[i] - 'a';
            int v = changed[i] - 'a';

            adj[u][v] = Math.min(adj[u][v],cost[i]);
        }

        for(int k = 0; k < 26; k++){

            for(int i = 0; i < 26; i++){

                for(int j = 0; j < 26; j++){

                    if(adj[i][k] == Integer.MAX_VALUE || 
                        adj[k][j] == Integer.MAX_VALUE){

                            continue;
                        }
                    
                    if(adj[i][j] == Integer.MAX_VALUE){

                        adj[i][j] = adj[i][k] + adj[k][j];
                    }
                    else{

                        adj[i][j] = Math.min(adj[i][j],adj[i][k] + adj[k][j]);
                    }
                }
            }
        }

        long minCost = 0;

        for(int i = 0; i < source.length(); i++){

            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';

            if(s != t){

                if(adj[s][t] == Integer.MAX_VALUE){

                    return -1;
                }

                minCost += adj[s][t];
            }
        }

        return minCost;
    }
}
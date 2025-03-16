class Solution {
    public int equalPairs(int[][] grid) {
        
        Map<List<Integer>,Integer>  mpp = new HashMap<>();

        int res = 0;

        for(int i = 0; i < grid.length; i++){

            List<Integer> ans = new ArrayList<>();

            for(int j = 0; j < grid[0].length; j++){

                ans.add(grid[i][j]);
            }

            mpp.put(ans,mpp.getOrDefault(ans,0)+1);
        }

        for(int i = 0; i < grid.length; i++){
            List<Integer> ans = new ArrayList<>();

            for(int j = 0; j < grid[0].length; j++){

                ans.add(grid[j][i]);
            }

            if(mpp.containsKey(ans)){

                res += mpp.get(ans);
            }
        }
        return res;
    }
}
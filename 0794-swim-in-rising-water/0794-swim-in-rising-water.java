class Solution {

    private static final int[][] directions = {
        {-1, 0},
        {0, 1},
        {1, 0},
        {0, -1}
    };

    int n,m;
    public void dfs(int i,int j,int[][] grid,boolean[][] visited,int x){

        if(i < 0 || i >= n || j < 0 || j >= m){

            return;
        }

        if(visited[i][j] || grid[i][j] > x){

            return;
        }

        visited[i][j] = true;

        for(int[] dir : directions){

            dfs(i + dir[0],j + dir[1],grid,visited,x);
        }

    }
    public boolean isPossible(int[][] grid,int x){

        
        boolean[][] visited = new boolean[n][n];

        dfs(0,0,grid,visited,x);

        return visited[n - 1][n - 1];
    }
    public int swimInWater(int[][] grid) {
        
        n = grid.length;
        m = grid[0].length;
        

        int low = 0,high = n * n;

        int res = high;

        while(low <= high){

            int mid = (low + high) / 2;

            if(isPossible(grid,mid)){

                res = mid;
                high = mid - 1;
            }
            else{

                low = mid + 1;
            }
        }

        return res;
    }
}
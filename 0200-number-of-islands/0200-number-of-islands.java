class Solution {
    private static int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    private boolean isSafe(char[][] grid,int r,int c,boolean[][] visited){

        return ((r >= 0 && r < grid.length) && (c >= 0 && c < grid[0].length) 
        && !visited[r][c] && grid[r][c] == '1');
    }
    private void bfs(char[][] grid,int r,int c,boolean[][] visited){

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{r,c});

        while(!q.isEmpty()){

            int[] top = q.poll();

            int row = top[0];
            int col = top[1];

            
        }
    }
    private void dfs(char[][] grid,int r,int c,boolean[][] visited){

        // if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length 
        // || visited[r][c] || grid[r][c] == '0'){

        //     return;
        // }

        if(!isSafe(grid,r,c,visited)){

            return;

        }
        visited[r][c] = true;

        for(int[] dir : directions){

            int x = r + dir[0];
            int y = c + dir[1];

            dfs(grid,x,y,visited);
        }

    }
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int noOfIslands = 0;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if(grid[i][j] == '1' && !visited[i][j]){

                    dfs(grid,i,j,visited);
                    noOfIslands++;
                }
            }
        }

        return noOfIslands;
    }
}
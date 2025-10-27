class Solution {
    private static int[][] directions = {{0,-1},{0,1},{1,0},{-1,0}};

    public boolean isSafe(int row,int col,int m,int n){

        if(row < 0 || row >= m){

            return false;
        }
        if(col < 0 || col >= n){

            return false;
        }

        return true;
    }
    
    public void bfs(int[][] grid,boolean[][] visited,Queue<int[]> q){
        int m = grid.length;
        int n = grid[0].length;

        while(!q.isEmpty()){

            int[] cell = q.poll();

            int row = cell[0];
            int col = cell[1];

            for(int[] dir : directions){

                int nRow = row + dir[0];
                int nCol = col + dir[1];

                if(isSafe(nRow,nCol,m,n) && grid[nRow][nCol] == 1
                    && !visited[nRow][nCol]){

                        visited[nRow][nCol] = true;
                        q.add(new int[]{nRow,nCol});
                    }
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if((i == 0 || j == 0 || i == m - 1 || j == n - 1) && 
                    grid[i][j] == 1){

                    visited[i][j] = true;
                    q.add(new int[]{i,j});
                }
            }
        }

        bfs(grid,visited,q);

        int nonReachable = 0;

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if(grid[i][j] == 1 && !visited[i][j]){

                    nonReachable++;
                }
            }
        }

        return nonReachable;
    }
}
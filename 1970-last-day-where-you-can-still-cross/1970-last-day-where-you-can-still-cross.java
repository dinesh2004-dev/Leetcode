class Solution {
    private static int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};

    private boolean isValid(int row,int col, int rowLen,int colLen){

        return row >= 0 && row < rowLen && col >= 0 && col < colLen;
    }

    public boolean dfs(int row,int col,boolean[][] water,boolean[][] visited){

        if(!isValid(row,col,visited.length,visited[0].length)){

            return false;
        }

        if(water[row][col]){

            return false;
        }

        if(row == visited.length - 1 && col < visited[0].length && !water[row][col] && !visited[row][col]){

            return true;
        }

        visited[row][col] = true;

        for(int[] dir : directions){

            int x = row  + dir[0];
            int y = col + dir[1];

            if(isValid(x,y,visited.length,visited[0].length) && 
            !water[x][y] && !visited[x][y]){

                if(dfs(x,y,water,visited)){

                    return true;
                }
            }
        }

        return false;
    }
    public boolean canReach(int day,int row,int col,int[][] cells){

        boolean[][] water = new boolean[row][col];
        boolean[][] visited = new boolean[row][col];

        for(int i = 0; i < day; i++){

            int x = cells[i][0];
            int y = cells[i][1];

            water[x - 1][y - 1] = true;
        }

        for(int i = 0; i < col; i++){

            if(dfs(0,i,water,visited)){

                return true;
            }
        }

        return false;
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        
        int low = 0,high = row * col;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(canReach(mid,row,col,cells)){

                low = mid + 1;
            }
            else{

                high = mid - 1;
            }
        }

        return high;
    }
}
class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        
        int m = x + k;
        int n = y + k;

        for(int i = y; i < n; i++){

            int r1 = x,c = i;
            int r2 = m - 1;

            while(r1 <= r2){

                int temp = grid[r1][c];
                grid[r1][c] = grid[r2][c];
                grid[r2][c] = temp;

                r1++;
                r2--;
            }
        }

        return grid;
    }
}
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;

        int[][] temp = new int[m][n];

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                int curr = i * n + j;

                int newEle = ( curr + k ) % (m * n);

                int row = newEle / n;
                int col = newEle % n;

                temp[row][col] = grid[i][j];
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < m; i++){

           List<Integer> t = new ArrayList<>();

            for(int j = 0; j < n; j++){

                t.add(temp[i][j]);
            }

            res.add(t);
        }

        return res;

    }
}
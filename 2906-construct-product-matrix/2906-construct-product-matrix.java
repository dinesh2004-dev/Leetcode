class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int size = m * n;

        int mod = 12345;

        int[] arr = new int[size];

        int idx = 0;

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                arr[idx++] = grid[i][j] % mod;
            }
        }

        int[] prefix = new int[size];
        int[] suffix = new int[size];

        prefix[0] = 1;

        for (int i = 1; i < size; i++) {
            prefix[i] = (int)((long)prefix[i - 1] * arr[i - 1] % mod);
        }

        
        
        suffix[size - 1] = 1;
        for (int i = size - 2; i >= 0; i--) {
            suffix[i] = (int)((long)suffix[i + 1] * arr[i + 1] % mod);
        }

        int[][] res = new int[m][n];
        idx = 0;
        for (int i = 0; i < size; i++) {
            int val = (int)((long)prefix[i] * suffix[i] % mod);
            res[idx / n][idx % n] = val;
            idx++;
        }

        return res;
    }
}
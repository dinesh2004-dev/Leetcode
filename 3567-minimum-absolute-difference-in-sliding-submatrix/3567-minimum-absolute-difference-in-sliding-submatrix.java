class Solution {
    public int minAbsDifference(int[][] grid, int rStart, int rEnd, int cStart, int cEnd) {
        int size = (rEnd - rStart + 1) * (cEnd - cStart + 1);
        int[] arr = new int[size];
        
        int idx = 0;
        for (int i = rStart; i <= rEnd; i++) {
            for (int j = cStart; j <= cEnd; j++) {
                arr[idx++] = grid[i][j];
            }
        }
        
        Arrays.sort(arr);
        
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < idx; i++) {
            if (arr[i] == arr[i - 1]) continue; // skip duplicates
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
            if (minDiff == 0) return 0;
        }
        
        return minDiff == Integer.MAX_VALUE ? 0 : minDiff;
    }

    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] res = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                res[i][j] = minAbsDifference(grid, i, i + k - 1, j, j + k - 1);
            }
        }

        return res;
    }
}

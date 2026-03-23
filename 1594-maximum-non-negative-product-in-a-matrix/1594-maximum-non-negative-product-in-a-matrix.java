class Pair{

    long max,min;

    public Pair(long max,long min){

        this.max = max;
        this.min = min;
    }
}
class Solution {
    Pair[][] memo;
    private Pair solve(int[][] grid,int r,int c){

        if(r == 0 && c == 0){

            return new Pair(grid[0][0],grid[0][0]);
        }

        if (memo[r][c] != null) return memo[r][c];

        long maxVal = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;

        if(r > 0){

            Pair pair = solve(grid,r - 1,c);
            long a = pair.max * grid[r][c];
            long b = pair.min * grid[r][c];
            maxVal = Math.max(maxVal,Math.max(a,b));
            minVal = Math.min(minVal,Math.min(a,b));

        }

         if(c > 0){

            Pair pair = solve(grid,r,c - 1);
            long a = pair.max * grid[r][c];
            long b = pair.min * grid[r][c];
            maxVal = Math.max(maxVal,Math.max(a,b));
            minVal = Math.min(minVal,Math.min(a,b));

        }

        memo[r][c] = new Pair(maxVal, minVal);

        return new Pair(maxVal,minVal);
    }
    public int maxProductPath(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

         memo = new Pair[m][n];

        Pair res = solve(grid,m - 1,n - 1);

        if(res.max < 0){

            return -1;
        }

        return (int) (res.max % 1000000007);

    }
}
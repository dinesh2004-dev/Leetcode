class Solution {
      private static int findBorderSum(int[][] mat,int r,int c,int k){

    if(k == 0) return mat[r][c];

    int sum = 0;

    // top -> right
    for(int i = 0; i < k; i++)
        sum += mat[r - k + i][c + i];

    // right -> bottom
    for(int i = 0; i < k; i++)
        sum += mat[r + i][c + k - i];

    // bottom -> left
    for(int i = 0; i < k; i++)
        sum += mat[r + k - i][c - i];

    // left -> top
    for(int i = 0; i < k; i++)
        sum += mat[r - i][c - k + i];

    return sum;
}
    public int[] getBiggestThree(int[][] grid) {
        
        int m = grid.length;
	   int n = grid[0].length;
	   
	

      TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

    for(int i = 0; i < m; i++){

        for(int j = 0; j < n; j++){

            int maxSize = Math.min(Math.min(i, m-1-i),
                               Math.min(j, n-1-j));

            for(int k = 0; k <= maxSize; k++){

                int sum = findBorderSum(grid, i, j, k);

                set.add(sum);
            }
    } 
    }

    int size = Math.min(3, set.size());
        int[] res = new int[size];

        int i = 0;
        for(int val : set){
            if(i == 3) break;
            res[i++] = val;
        }

        return res;
}
}
    

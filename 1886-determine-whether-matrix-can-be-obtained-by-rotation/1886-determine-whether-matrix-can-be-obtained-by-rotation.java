class Solution {
    private boolean equals(int[][] mat,int[][] target){

        int m = mat.length;
        int n = mat[0].length;

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if(mat[i][j] != target[i][j]){

                    return false;
                }
            }
        }

        return true;
    }
    private int[][] rotate(int[][] mat){

        int m = mat.length;
        int n = mat[0].length;

        int res[][] = new int[m][n];

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                res[j][n - i - 1] = mat[i][j];
            }
        }

        return res;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        
        for(int i = 0; i < 4; i++){

            if(equals(mat,target)){

                return true;
            }

            mat = rotate(mat);
        }

        return false;
    }
}
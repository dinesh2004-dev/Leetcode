class Solution {
    private void reverse(int[] arr){

        int left = 0,right = arr.length - 1;

        while(left < right){

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
    public void rotate(int[][] matrix) {
        

        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < n; i++){

            for(int j = 0; j < i; j++){

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }

        for(int[] mat : matrix){

            reverse(mat);
        }
    }
}
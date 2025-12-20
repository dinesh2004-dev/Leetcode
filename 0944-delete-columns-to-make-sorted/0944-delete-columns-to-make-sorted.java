class Solution {
    public int minDeletionSize(String[] strs) {

        int count = 0;
        int m = strs.length;
        int n = strs[0].length();

        // Convert all strings to char arrays first
        char[][] matrix = new char[m][];
        for(int i = 0; i < m; i++){
            matrix[i] = strs[i].toCharArray();
        }

        for(int col = 0; col < n; col++){

            char prev = matrix[0][col];

            for(int row = 1; row < m; row++){

                if(prev > matrix[row][col]){
                    count++;
                    break;
                }

                prev = matrix[row][col];
            }
        }

        return count;
    }
}

class Solution {
    public int minSwaps(int[][] grid) {
        
        int n = grid.length;

        int[] zeros = new int[n];

        for(int i = 0; i < n; i++){

            int count = 0;

            int j = n - 1;

            while(j >= 0 && grid[i][j] == 0){

                count++;
                j--;
            }

            zeros[i] = count;
        }

        //  for(int i = 0; i < n; i++){
            
        //     System.out.println(zeros[i]);
        // }

        int minSwaps = 0;

        for(int i = 0; i < n; i++){

            int reqZeros = n - i - 1;

            int j = i;

            while(j < n && zeros[j] < reqZeros){

                j++;
            }

            if(j == n){

                return -1;
            }

            while(j > i){

                int temp = zeros[j];
                zeros[j] = zeros[j - 1];
                zeros[j - 1] = temp;
                j--;
                minSwaps++;
            }
        }

        return minSwaps;
    }
}
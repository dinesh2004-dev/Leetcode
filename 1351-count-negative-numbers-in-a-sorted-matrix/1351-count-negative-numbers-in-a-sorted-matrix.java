class Solution {
    private int lowerBound(int[] arr){

        int n = arr.length;

        int low = 0,high = n - 1;
        int ans = n;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(arr[mid] < 0){

                ans = mid;
                high = mid - 1;
    
            }
            else{
                
                low = mid + 1;
            }
        }

        return n - ans;
    }
    public int countNegatives(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int negs = 0;

        for(int i = 0; i < n; i++){

            negs += lowerBound(grid[i]);

        }

        return negs;
    }
}
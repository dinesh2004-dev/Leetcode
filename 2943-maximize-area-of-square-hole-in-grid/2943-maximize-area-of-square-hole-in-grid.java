class Solution {
    private int longestConsecutive(int[] arr){

        int n = arr.length;
        int max = 1,cur = 1;

        for(int i = 1; i < n; i++){

            if(arr[i] == arr[i - 1] + 1){

                cur++;
            }
            else{

                max = Math.max(max,cur);
                cur = 1;
            }
        }

        max = Math.max(max,cur);

        return max;
    }
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {

        Arrays.sort(hBars);
        Arrays.sort(vBars);

       int maxH = longestConsecutive(hBars);
       int maxV = longestConsecutive(vBars);

       int height = maxH + 1;
       int width = maxV + 1;

       int area = Math.min(height,width);

       return area * area;
        
    }
}
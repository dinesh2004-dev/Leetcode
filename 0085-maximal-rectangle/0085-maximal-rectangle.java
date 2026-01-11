class Solution {
    public int findLargestArea(int[] heights){

        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){

            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){

                int ind = st.pop();

                int pse = st.isEmpty() ? -1 : st.peek();
                int nse = i;

                int area = heights[ind] * (nse - pse - 1);
                maxArea = Math.max(area,maxArea);
            }

            st.add(i);
        }

        while(!st.isEmpty()){

            int ind = st.pop();

            int nse = n;

            int pse = st.isEmpty() ? -1 : st.peek();

            int area = heights[ind] * (nse - pse - 1);
            maxArea = Math.max(area,maxArea);
        }

        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] prefixSum = new int[m][n];

        for(int i = 0; i < n; i++){

            int sum = 0;

            for(int j = 0; j < m; j++){

                sum += matrix[j][i] - '0';

                if(matrix[j][i] == '0'){

                    sum = 0;
                     prefixSum[j][i] = 0;
                }
                else{

                    prefixSum[j][i] = sum;
                }
            }
        }

        int maxArea = Integer.MIN_VALUE;

        for(int[] prefix : prefixSum){

            int area = findLargestArea(prefix);
            maxArea = Math.max(maxArea,area);
        }

        return maxArea;
    }
}
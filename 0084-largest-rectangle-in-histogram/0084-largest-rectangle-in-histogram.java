class Solution {
    // private int[] findNSE(int[] heights){

    //     int n = heights.length;

    //     int[] nse = new int[n];

    //     Arrays.fill(nse,n);
        
    //     Stack<Integer> st = new Stack<>();

    //     for(int i = n - 1; i >= 0; i--){

    //         while(!st.isEmpty() && heights[st.peek()] >= heights[i]){

    //             st.pop();
    //         }

    //         nse[i] = st.isEmpty() ? n : st.peek();

    //         st.add(i);
    //     }

    //     return nse;
    // }

    //  private int[] findPSE(int[] heights){

    //     int n = heights.length;

    //     int[] pse = new int[n];

    //     Arrays.fill(pse,-1);
        
    //     Stack<Integer> st = new Stack<>();

    //     for(int i = 0; i < n; i++){

    //         while(!st.isEmpty() && heights[st.peek()] > heights[i]){

    //             st.pop();
    //         }

    //         pse[i] = st.isEmpty() ? -1 : st.peek();

    //         st.add(i);
    //     }

    //     return pse;
    // }
    public int largestRectangleArea(int[] heights) {
        
        // int[] nse = findNSE(heights);
        // int[] pse = findPSE(heights);

        // int maxArea = Integer.MIN_VALUE;

        // int n = heights.length;

        // for(int i = 0; i < n; i++){

        //     int area = heights[i] * (nse[i] - pse[i] -1);

        //     maxArea = Math.max(area,maxArea);
        // }

        // return maxArea;

        int n = heights.length;

        Stack<Integer> st = new Stack<>();

        int maxArea = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){

            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){

                int nse = i;

                int val = heights[st.pop()];

                int pse = st.isEmpty() ? -1 : st.peek();

                int area = val * (nse - pse - 1);

                maxArea = Math.max(maxArea,area);

            }

            st.add(i);
        }

        while(!st.isEmpty()){

            int nse = n;

            int val = heights[st.pop()];

            int pse = st.isEmpty() ? -1 : st.peek();

            int area = val * (nse - pse - 1);

            maxArea = Math.max(maxArea,area);
        }

        return maxArea;
    }
}
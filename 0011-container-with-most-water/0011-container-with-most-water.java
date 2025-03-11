class Solution {
    public int maxArea(int[] height) {

        int i = 0,j = height.length - 1;

        int maxArea = Integer.MIN_VALUE;

        while(i < j){

            maxArea = Math.max(maxArea,(j - i)* Math.min(height[i],height[j]));

            if(height[i] >= height[j]){
                 j--;
            }
            else{
                i++;
            }
        }
        return maxArea;
        
    }
}
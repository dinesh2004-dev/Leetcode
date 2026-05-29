class Solution {
    // private int[] findPrefixMax(int[] heights){

    //     int n = heights.length;

    //     int[] prefix = new int[n];

    //     prefix[0] = heights[0];

    //     for(int i = 1; i < n; i++){

    //         prefix[i] = Math.max(prefix[i - 1],heights[i]);
    //     }

    //     return prefix;
    // }
    // private int[] findSuffixMax(int[] heights){

    //     int n = heights.length;

    //     int[] suffix = new int[n];

    //     suffix[n - 1] = heights[n - 1];

    //     for(int i = n - 2; i >= 0; i--){

    //         suffix[i] = Math.max(suffix[i + 1],heights[i]);
    //     }

    //     return suffix;
    // }
    public int trap(int[] height) {
        
        int n = height.length;

        int left = 0,right = n - 1;
        int leftMax = 0,rightMax = 0,res = 0;

        while(left <= right){

            if(height[left] <= height[right]){

                if(height[left] > leftMax){

                    leftMax = height[left];
                }
                else{

                    res = res + (leftMax - height[left]);
                }

                left++;
            }
            else{

                if(height[right] > rightMax){

                    rightMax= height[right];
                }
                else{

                    res = res + (rightMax - height[right]);
                }

                right--;
            }
        }

        return res;
    }
}
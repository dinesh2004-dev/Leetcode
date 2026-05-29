class Solution {
    private int[] findPrefixMax(int[] heights){

        int n = heights.length;

        int[] prefix = new int[n];

        prefix[0] = heights[0];

        for(int i = 1; i < n; i++){

            prefix[i] = Math.max(prefix[i - 1],heights[i]);
        }

        return prefix;
    }
    private int[] findSuffixMax(int[] heights){

        int n = heights.length;

        int[] suffix = new int[n];

        suffix[n - 1] = heights[n - 1];

        for(int i = n - 2; i >= 0; i--){

            suffix[i] = Math.max(suffix[i + 1],heights[i]);
        }

        return suffix;
    }
    public int trap(int[] height) {
        
        int n = height.length;

        int[] prefix = findPrefixMax(height);
        int[] suffix = findSuffixMax(height);

        int res = 0;

        for(int i = 0; i < n; i++){

            res = res + (Math.min(prefix[i],suffix[i]) - height[i]);
        }

        return res;
    }
}
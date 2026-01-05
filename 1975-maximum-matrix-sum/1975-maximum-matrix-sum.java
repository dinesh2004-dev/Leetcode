class Solution {
    public long maxMatrixSum(int[][] matrix) {
        
        long totalSum = 0;
        long minVal = Integer.MAX_VALUE;
        int negCount = 0;

        for(int[] mat : matrix){

            for(int val : mat){

                totalSum += Math.abs(val);
                minVal = Math.min(minVal,Math.abs(val));

                if(val < 0){

                    negCount++;
                }
            }
        }

        if(negCount % 2 != 0){

            totalSum -= 2 * minVal;
        }

        return totalSum;
    }
}
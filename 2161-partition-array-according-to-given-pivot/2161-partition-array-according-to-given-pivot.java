class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        int n = nums.length;

        int i = 0,j = n - 1;
        int i1 = 0,j1 = n - 1;

        int[] res = new int[n];

        while(i < n && j >= 0){

            if(nums[i] < pivot){

                res[i1++] = nums[i];
            }
            if(nums[j] > pivot){

                res[j1--] = nums[j];
            }

            i++;
            j--;
        }

        for(int k = i1; k <= j1; k++){

            res[k] = pivot;
        }

        return res;
    }
}
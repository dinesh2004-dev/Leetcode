class Solution {
    long[] prefixSum;
    int l,u;
    int count = 0;

    private void merge(int left,int mid,int right){

        int i = left,j = mid + 1;

        List<Long> temp = new ArrayList<>();

        while(i <= mid && j <= right){

            if(prefixSum[i] > prefixSum[j]){

                temp.add(prefixSum[j]);
                j++;
            }
            else{

                temp.add(prefixSum[i]);
                i++;
            }
        }

        while(i <= mid){

            temp.add(prefixSum[i]);
            i++;
        }

        while(j <= right){

            temp.add(prefixSum[j]);
            j++;
        }

        for(int k = 0; k < temp.size(); k++){

            prefixSum[k + left] = temp.get(k);
        }
    }

    private void mergeSort(int left,int right){

        if(left >= right){

            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(left,mid);
        mergeSort(mid + 1,right);

        int i = mid + 1,j = mid + 1;

        for(int k = left; k <= mid; k++){

            while(i <= right && prefixSum[i] - prefixSum[k] < l){
                i++;
            }

            while(j <= right && prefixSum[j] - prefixSum[k] <= u){

                j++;
            }

            count += (j - i);
        }

        merge(left,mid,right);
    }
    public int countRangeSum(int[] nums, int lower, int upper) {
        
        int n = nums.length;

        l = lower;
        u = upper;


        prefixSum = new long[n + 1];

        for(int i = 0; i < n; i++){

            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        mergeSort(0,n);

        return count;
    }
}
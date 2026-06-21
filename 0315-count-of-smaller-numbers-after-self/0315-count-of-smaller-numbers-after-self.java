class Solution {
    List<Integer> res;

    private void merge(int[][] arr,int left,int mid,int right){

        int l = left,r = mid + 1;

        List<int[]> temp = new ArrayList<>();

        while(l <= mid && r <= right){

            if(arr[l][0] > arr[r][0]){

                int idx = arr[l][1];
                res.set(idx,res.get(idx) + (right - r + 1));
                temp.add(arr[l]);
                l++;
            }
            else{

                temp.add(arr[r]);
                r++;
            }
        }

        while(l <= mid){

            temp.add(arr[l]);
            l++;
        }

        while(r <= right){

            temp.add(arr[r]);
            r++;
        }

        for(int i = 0; i < temp.size(); i++){

            arr[i + left] = temp.get(i);
        }
    }

    private void mergeSort(int[][] arr,int left,int right){

        if(left >= right){

            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }
    public List<Integer> countSmaller(int[] nums) {
        
        int n = nums.length;

        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++){

            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        res = new ArrayList<>(Collections.nCopies(n,0));

        mergeSort(arr,0,n - 1);

        return res;
    }
}
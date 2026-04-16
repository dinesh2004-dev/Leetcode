class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int n = arr.length;
        int[][] temp = new int[n][2];

        for(int i = 0; i < n; i++){

            temp[i][0] = Math.abs(arr[i] - x);
            temp[i][1] = i;
        }

        Arrays.sort(temp,(u,v) -> u[0] - v[0]);

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < n ; i++){
            if(res.size() == k){
                Collections.sort(res);
                return res;
            }
            res.add(arr[temp[i][1]]);
        }
        Collections.sort(res);
        return res;
    }
}
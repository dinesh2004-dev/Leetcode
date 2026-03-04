class Solution {

    Set<Integer> set= new HashSet<>();
    Set<String> dp= new HashSet<>();

    public int subarrayBitwiseORs(int[] arr) {

        int n= arr.length;

        for(int i=0;i<n;i++){
            solve(i,arr,0);
        }

        return set.size();
    }

    public void solve(int i,int arr[], int currOr){

        if(i==arr.length){
            return;
        }

        String key=i+","+currOr;
        if(dp.contains(key)) return;

        dp.add(key);

        currOr|=arr[i];
        set.add(currOr);
        solve(i+1,arr,currOr);
    }
}
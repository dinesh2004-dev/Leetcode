class Solution {

    Set<Integer> set= new HashSet<>();
    Set<String> dp= new HashSet<>();

    public int subarrayBitwiseORs(int[] arr) {

        Set<Integer> result = new HashSet<>();
        Set<Integer> prev = new HashSet<>();
        
        for (int num : arr) {
            Set<Integer> curr = new HashSet<>();
            curr.add(num);
            
            for (int prevOr : prev) {
                curr.add(prevOr | num);
            }
            
            result.addAll(curr);
            prev = curr;
        }
        
        return result.size();
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
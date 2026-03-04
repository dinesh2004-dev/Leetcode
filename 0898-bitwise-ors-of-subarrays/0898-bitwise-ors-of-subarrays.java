class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        
        Set<Integer> res = new HashSet<>();
        Set<Integer> curr = new HashSet<>();

        for(int i = 0; i < arr.length; i++){

            Set<Integer> next = new HashSet<>();

            next.add(arr[i]);

            for(int y : curr){

                next.add(y | arr[i]);
            }

            res.addAll(next);

            curr = next;
        }

        return res.size();
    }
}
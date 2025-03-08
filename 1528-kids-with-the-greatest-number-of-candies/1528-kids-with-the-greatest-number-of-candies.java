class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        int max = Arrays.stream(candies).max().getAsInt();

        List<Boolean> res = new ArrayList<>(Collections.nCopies(candies.length,true));

        

        for(int i = 0; i < candies.length; i++){

            if(candies[i] + extraCandies < max){

                res.set(i,false);
            }
        }
    return res;
        
    }
}
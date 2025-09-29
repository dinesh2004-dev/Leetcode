class Solution {
    public String largestNumber(int[] nums) {
        
        int n = nums.length;

        String[] strNum = new String[n];

        for(int i = 0; i < n; i++){

            strNum[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strNum,(x,y) -> (y + x).compareTo(x + y));

        if(strNum[0].equals("0")){

            return "0";
        }

        StringBuilder s = new StringBuilder();

        for(String str : strNum){

            s.append(str);
        }

        return s.toString();
    }
}
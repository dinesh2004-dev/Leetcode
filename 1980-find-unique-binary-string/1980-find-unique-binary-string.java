class Solution {
    public String findDifferentBinaryString(String[] nums) {
        
        int n = nums.length;
        char[] hash = new char[n];

        for(int i = 0; i < n; i++){

            hash[i] = nums[i].charAt(i);
        }

       StringBuilder res = new StringBuilder();

       for(char ch : hash){

            if(ch == '1'){

                res.append('0');
            }
            else{

                res.append('1');
            }
       }

       return res.toString();
    }
}
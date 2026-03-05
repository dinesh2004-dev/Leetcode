class Solution {
    public int minOperations(String s) {
        
        char[] charArray = s.toCharArray();

       int minOperations1 = 0;
        int minOperations2 = 0;

       char expected1 = '0';
       char expected2 = '1';

       for(char ch : charArray){

            if(expected1 != ch){

                minOperations1++;
            }

            if(expected2 != ch){

                minOperations2++;
            }


            expected1 = (expected1 == '0') ? '1' : '0';
             expected2 = (expected2 == '0') ? '1' : '0';
       }

    
       return Math.min(minOperations1,minOperations2);


    }
}
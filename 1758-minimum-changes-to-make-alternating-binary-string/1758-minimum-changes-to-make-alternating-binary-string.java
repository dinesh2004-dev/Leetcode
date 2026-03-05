class Solution {
    public int minOperations(String s) {
        
        char[] charArray = s.toCharArray();

       int minOperations1 = 0;

       char expected = '0';

       for(char ch : charArray){

            if(expected != ch){

                minOperations1++;
            }

            expected = (expected == '0') ? '1' : '0';
       }

       int minOperation2 = 0;

       expected = '1';

        for(char ch : charArray){

            if(expected != ch){

                minOperation2++;
            }

            expected = (expected == '0') ? '1' : '0';
       }

       return Math.min(minOperations1,minOperation2);


    }
}
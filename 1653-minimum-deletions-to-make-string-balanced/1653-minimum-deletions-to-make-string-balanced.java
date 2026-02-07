class Solution {
    public int minimumDeletions(String s) {
        
        int countA = 0,countB = 0;

        char[] chars = s.toCharArray();

        int n = chars.length;

       

        for(int i = 0; i < n; i++){

            if(chars[i] == 'a'){

                countA++;
            }
        }

    

        if(countA == n){

            return 0;
        }

        int minOperations = countA;

        for(int i = 0; i < n; i++){

            

            if(chars[i] == 'a'){

                countA--;
            }
            else if(chars[i] == 'b'){

                countB++;
            }

            minOperations = Math.min(minOperations,countA + countB);
        }

       

        return minOperations;
    }
}
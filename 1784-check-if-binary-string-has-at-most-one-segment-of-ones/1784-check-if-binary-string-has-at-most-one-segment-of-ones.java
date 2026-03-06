class Solution {
    public boolean checkOnesSegment(String s) {
        
        int n = s.length();

        char[] charArray = s.toCharArray();

        int cnt = 0;

        for(int i = 0; i < n; i++){

            

           if(charArray[i] == '1'){

                 int j = i + 1;

                while(j < n && charArray[j] == '1'){

                    j++;
                }

              

                    cnt++;
                

                i = j - 1;
           }

           if(cnt > 1){

                return false;
            }
        }

        

        return true;
    }
}
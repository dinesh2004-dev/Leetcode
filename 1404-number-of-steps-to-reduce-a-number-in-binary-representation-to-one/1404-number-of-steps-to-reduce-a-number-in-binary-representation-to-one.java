class Solution {
    public int numSteps(String s) {
        
        // int n = s.length;
        int res = 0;

        StringBuilder str = new StringBuilder(s);

        while(str.length() != 1){

            if(str.charAt(str.length() - 1) == '1'){

                int size = str.length();
                int carry = 1;

                for(int i = size - 1; i >= 0; i--){

                    int bit = (str.charAt(i) - '0') + carry;
                    str.setCharAt(i,(char) ('0' + (bit & 1)));
                    carry = (bit >> 1);
                    if(carry == 0){

                        break;
                    }
                 }

                 if(carry == 1){

                    str.insert(0,'1');
                 }
            }
            else{

                str.deleteCharAt(str.length() - 1);
            }

            res++;
        }

        return res;
    }
}
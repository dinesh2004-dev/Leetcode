class Solution {
    public char processStr(String s, long k) {
        
        StringBuilder str = new StringBuilder();

        int n = s.length();

        long len = 0;

        for(char ch : s.toCharArray()){

            if(Character.isLetter(ch)){

                len++;
            }
            else if(ch == '*'){

                len = Math.max(len - 1,0L);
            }
            else if(ch == '#'){

                len = len + len;
            }

        }

       if(k >= len){

            return '.';
       }

       for(int i = n - 1; ; i--){

            char ch = s.charAt(i);

            switch(ch){

                case '*':
                    len++;
                    break;
                case '#':
                   if(k >= len / 2){

                        k -= len / 2;
                   }
                   len /= 2;
                   break;
                case '%':

                    k = len - 1 - k;
                    break;
                default:

                    if(len == k + 1){

                        return ch;
                    }

                    len--;
            }
       }
    }
}
class Solution {
    public void reverseString(char[] c,int start,int end){

        while(start < end){

            char temp = c[start];

            c[start] = c[end];

            c[end] = temp;

            start++;
            end--;
        }
    }
    public String reverseWords(String s) {
        
        int n = s.length();

        int i = 0, j = 0,start = 0,end = 0;

        char[] c = s.toCharArray();

        reverseString(c,0,n - 1);

        while(j < n){
            if(c[j] == ' '){
                j++;
                continue;
            }
            start = i;
            while(j < n && c[j] != ' '){

                c[i] = c[j];

                i++;
                j++;
            }
            end = i - 1;

            reverseString(c,start,end);

            if(i < n){

                c[i++] = ' ';
            }

            
        }

        return new String(c).substring(0,end + 1);
    }
}

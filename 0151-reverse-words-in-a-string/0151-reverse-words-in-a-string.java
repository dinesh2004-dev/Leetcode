class Solution {
    private void reverse(char[] chars,int start,int end){

        while(start <= end){

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
    }
    public String reverseWords(String s) {
        
        int n = s.length();

        char[] chars = s.toCharArray();

        StringBuilder str = new StringBuilder();

        reverse(chars,0,n - 1);
        int i = 0,j = 0,start = 0,end = 0;
        while(i < n){

            if(chars[i] == ' '){

                i++;
                continue;
            }

            start = j;
            

            while(i < n && chars[i] != ' '){

                chars[j] = chars[i];

                i++;
                j++;
            }

            end = j - 1;

            reverse(chars,start,end);

            if(j < n){

                chars[j] = ' ';
                j++;
            }

        }

        return new String(chars).substring(0,end + 1);

        // return new String(chars);
    }
}
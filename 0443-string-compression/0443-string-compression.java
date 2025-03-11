class Solution {
    public int compress(char[] chars) {

        int n = chars.length;

        int idx = 0;

        for(int i = 0; i < n; i++){

            int count = 0;

            char ch = chars[i];

            while(i < n && ch == chars[i]){

                count++;

                i++;
            }

            if(count == 1){

                chars[idx++] = ch;
            }
            else{
                chars[idx++] = ch;

                for(char ele : Integer.toString(count).toCharArray()){

                    chars[idx++] = ele;
                }
            }
            i--;
        }
        return idx;
        
    }
}
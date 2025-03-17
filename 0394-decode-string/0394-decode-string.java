class Solution {
    public String decodeString(String s) {

        

        Stack<Integer> number = new Stack<>();

        Stack<StringBuilder> string = new Stack<>();

        StringBuilder str = new StringBuilder();

        int n = 0;

        for(char c : s.toCharArray()){

            if(Character.isDigit(c)){
                n = n * 10 + (c -'0');
            }
            else if(c == '['){

                number.push(n);
                n = 0;
                string.push(str);
                str = new StringBuilder();
            }
            else if(c == ']'){

                int k = number.pop();

                StringBuilder temp = str;

                str = string.pop();

                while(k-- > 0){
                    str.append(temp);
                }
            }
            else{

                str.append(c);
            }

        }
        return str.toString();
        
    }
}
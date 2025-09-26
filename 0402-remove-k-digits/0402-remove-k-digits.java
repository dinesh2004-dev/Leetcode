class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Character> st = new Stack<>();

        int n = num.length();

        for(int i = 0; i < n; i++){

            char ch = num.charAt(i);
            while(!st.isEmpty() && k > 0 && st.peek() > ch){
               
                k--;
                st.pop();
                
            }

            st.push(ch);

        }

        while(k > 0 && !st.isEmpty()){

            k--;
            st.pop();
        }

        StringBuilder s = new StringBuilder();

        while(!st.isEmpty()){

            s.append(st.pop());
        }

        s.reverse();

        while(s.length() > 0 && s.charAt(0) == '0'){

            s.deleteCharAt(0);
        }
        if(s.length() == 0){

            return "0";
        }
        return s.toString();
    }
}
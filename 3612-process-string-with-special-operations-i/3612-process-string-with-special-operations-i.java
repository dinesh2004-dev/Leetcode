class Solution {
    
    
    public String processStr(String s) {
        
        StringBuilder res = new StringBuilder();

        int n = s.length();

        for(char ch : s.toCharArray()){

            if(Character.isLetter(ch)){
                res.append(ch);
            }
            else if(ch == '*' && res.length() >= 1){

                res.deleteCharAt(res.length() - 1);
            }
            else if(ch == '#'){

                res.append(res.toString());
            }
            else if(ch == '%'){
                res.reverse();
            }

            
        }

        return res.toString();
    }
}
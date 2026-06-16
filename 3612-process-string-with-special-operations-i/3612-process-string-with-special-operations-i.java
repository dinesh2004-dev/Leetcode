class Solution {
    private void duplicate(StringBuilder res){

        int n = res.length();

        for(int i = 0; i < n; i++){

            res.append(res.charAt(i));
        }
    }
    
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

                duplicate(res);
            }
            else if(ch == '%'){
                res.reverse();
            }

            System.out.println(res.toString());
        }

        return res.toString();
    }
}
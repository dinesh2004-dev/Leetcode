class Solution {
    public String makeFancyString(String s) {
        StringBuilder res = new StringBuilder();
        int cnt = 1;
        char lastChar = s.charAt(0);
        res.append(lastChar);
        for(int i = 1; i < s.length(); i++){
            if(lastChar == s.charAt(i)){
                cnt++;
                if(cnt < 3){
                    res.append(lastChar);
                }
            }
            else if(lastChar != s.charAt(i)){
                lastChar = s.charAt(i);
                res.append(lastChar);
                cnt = 1;
            }
        }
        return res.toString();
    }
}
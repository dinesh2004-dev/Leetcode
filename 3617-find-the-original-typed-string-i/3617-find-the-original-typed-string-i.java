class Solution {
    public int possibleStringCount(String word) {
        int cnt = 1,res = 1;
        for(int i = 1; i < word.length(); i++){
            if(word.charAt(i) == word.charAt(i - 1)){
                cnt++;
            }
            else{
                if(cnt > 1){
                    res += cnt - 1;
                }
                cnt = 1;
            }

        }
        if(cnt > 1){
            res += cnt - 1;
        }
        return res;
    }
}
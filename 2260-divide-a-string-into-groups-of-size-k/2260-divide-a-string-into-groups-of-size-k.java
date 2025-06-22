class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int group = (n + k - 1) / k;
        String[] ans = new String[group];

        for(int i = 0; i < group; i++){
            StringBuilder str = new StringBuilder();
            for(int j = 0; j < k; j++){
                int index = i * k + j;
                if(index < n){
                    str.append(s.charAt(index));
                }
                else{
                    str.append(fill);
                }
            }
            ans[i] = str.toString();
        }
        return ans;
    }
}
class Solution {
    private static char invert(char ch){
    
        return ch == '0' ? '1' : '0';
    }
    private void reverse(StringBuilder str){
        
        // StringBuilder str = new StringBuilder(rev);
        
        int l = 0,r = str.length() - 1;
        
        while(l <= r){
            
            char temp = str.charAt(l);
            str.setCharAt(l,invert(str.charAt(r)));
            str.setCharAt(r,invert(temp));
            l++;
            r--;
            
        }
    }
    private void solve(StringBuilder str,int n){

        if(n == 0){

            return;
        }

        StringBuilder rev = new StringBuilder(str);
        reverse(rev);

        str.append("1").append(rev);

        solve(str,n - 1);
        

    }
    public char findKthBit(int n, int k) {
        
       StringBuilder str = new StringBuilder("0");

       solve(str,n - 1);

       for(int i = 1; i <= k; i++){

            if(i == k){

                return str.charAt(i - 1);
            }
       }

       return '1';
    }
}
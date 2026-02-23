class Solution {
    public boolean hasAllCodes(String s, int k) {
        
        int needed = 1 << k;

        boolean[] seen = new boolean[needed];

        int mask = needed - 1;
        int window = 0;
        int cnt = 0;

        for(int i = 0; i < s.length(); i++){

            window = (((window << 1) & mask) | s.charAt(i) - '0');

            if(i >= k - 1 && !seen[window]){

                seen[window] = true;
                cnt++;

                if(cnt == needed){

                    return true;
                }
            }
        }

        return false;
    }
}
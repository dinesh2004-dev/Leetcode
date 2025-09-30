class Solution {
    public int minDeletions(String s) {
        
        int n = s.length();

        int[] hash = new int[26];

        for(int i = 0; i < n; i++){

            char ch = s.charAt(i);

            hash[ch - 'a']++;
        }

        Arrays.sort(hash);

        int del = 0;

        for(int i = 24; i >= 0; i--){

            if(hash[i] == 0){

                break;
            }

            if(hash[i] >= hash[i + 1]){

                int prev = hash[i];
                hash[i] = Math.max(0,hash[i + 1] - 1);
                del += prev - hash[i];
            }
        }

        return del;

    }
    
}
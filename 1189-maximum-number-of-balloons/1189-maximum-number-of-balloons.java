class Solution {
    public int maxNumberOfBalloons(String text) {
        
        int[] hash = new int[26];

        for(char ch : text.toCharArray()){

            hash[ch - 'a']++;
        }
        
        int cnt = 0;

        String balloon = "balloon";

        while(true){

            int temp = 0;
            boolean exit = false;

            for(char ch : balloon.toCharArray()){

                if(hash[ch - 'a'] <= 0){

                    exit = true;

                    break;
                }
                if(balloon.indexOf(ch) != -1){

                    temp++;
                    hash[ch - 'a']--;
                }

            }

            if(temp == balloon.length()){

                cnt++;
            }

            if(exit){

                break;
            }
        }

        return cnt;
    }
}
class Solution {
    public int minFlips(String target) {
        
        

        int k = 0;

        for( ; k < target.length(); k++){

            char tar = target.charAt(k);

            if(tar != '0'){

                break;
            }
        }

        if(k == target.length()){

            return 0;
        }

        int cnt = 1;
        char digit = '1';
       

        for(int i = k + 1; i < target.length(); i++){

            char tar = target.charAt(i);

            if(tar != digit){

                cnt++;
                digit = tar;
            }

        }

       

        return cnt;
    }
}
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        
        int left = 0,right = 0,blank = 0;

        for(char ch : moves.toCharArray()){

            if(ch == 'L'){

                left++;
            }
            else if(ch == 'R'){

                right++;
            }
            else{

                blank++;
            }
        }

        int res = 0;

        if(left > right){

            res = left + blank - right;
        }
        else{

            res = right + blank - left;
        }

        return res;
    }
}
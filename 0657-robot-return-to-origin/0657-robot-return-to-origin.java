class Solution {
    public boolean judgeCircle(String moves) {
        
        int[] origin = {0,0};

        for(char move : moves.toCharArray()){

            if(move == 'U'){

                origin[0]--;
            }
            else if(move == 'D'){

                origin[0]++;
            }
            else if(move == 'R'){

                origin[1]++;
            }
            else if(move == 'L'){

                origin[1]--;
            }
        }

        return origin[0] == 0 && origin[1] == 0;
    }
}
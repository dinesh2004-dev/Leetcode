class Solution {
    public boolean rotateString(String s, String goal) {

        if(s.length() != goal.length()){

            return false;
        }
        
       

        String str = goal + goal;

        int n = goal.length();
        int n1 = s.length();

        for(int i = 0; i < str.length(); i++){

            if(str.charAt(i) == s.charAt(0)){

                int j = 0;
                int k = i;

                while(k < str.length() && j < n1  &&  str.charAt(k) == s.charAt(j)){

                    k++;
                    j++;

                }

                if(j == n1){

                    return true;
                }
            }
        }

        return false;
    }
}
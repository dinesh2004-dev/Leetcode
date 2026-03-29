class Solution {
    public boolean canBeEqual(String s1, String s2) {

        // if(s1.equals(s2)){

        //     return true;
        // }
        
        for(int i = 0; i < 4; i++){

            int f = i + 2;
            int b = i - 2;
            if(s1.charAt(i) == s2.charAt(i)){

                continue;
            }

            if(f < 4 && s1.charAt(i) != s2.charAt(f)){

                return false;
            }
            if(b >= 0 && s1.charAt(i) != s2.charAt(b)){

                return false;
            }
        }

        return true;
    }
}
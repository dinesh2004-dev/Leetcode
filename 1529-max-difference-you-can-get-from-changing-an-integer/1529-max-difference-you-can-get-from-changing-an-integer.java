class Solution {
    public int maxDiff(int num) {
        String numStr = String.valueOf(num);

        int a = getMax(numStr);

        int b = getMin(numStr);

        return a - b;
    }
    public int getMax(String numStr){

        for(char ch : numStr.toCharArray()){

            if(ch != '9'){
                
                return Integer.parseInt(numStr.replace(ch,'9'));
            }
        }

        return Integer.parseInt(numStr);
    }
    public int getMin(String numStr){
        char firstDigit = numStr.charAt(0);

        if(firstDigit != '1'){
            return Integer.parseInt(numStr.replace(firstDigit,'1'));
        }

        for(int i = 1; i < numStr.length(); i++){
            char c = numStr.charAt(i);

            if(c != '0' && c != '1'){
                return Integer.parseInt(numStr.replace(c,'0'));
            }
        }
        return Integer.parseInt(numStr);
    }
}
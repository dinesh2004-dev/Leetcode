class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        
        List<String> res = new ArrayList<>();

        for(int i = 0; i < 12; i++){

            for(int j = 0; j < 60; j++){

                int totalBits = Integer.bitCount(i) + Integer.bitCount(j);

                if(totalBits == turnedOn){
                    
                    res.add(i + ":" + String.format("%02d",j));
                }
            }
        }

        return res;
    }
}
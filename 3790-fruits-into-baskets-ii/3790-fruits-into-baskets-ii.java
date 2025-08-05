class Solution {
    
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
       int n = fruits.length;
       boolean[] toBePlaced = new boolean[n];
       int notPlaced = 0;
       for(int i = 0; i < n; i++){
            boolean placed = false;
            for(int j = 0; j < n; j++){
                if(!toBePlaced[j] && fruits[i] <= baskets[j]){
                    toBePlaced[j] = true;
                    placed = true;
                    break;
                }
            }
            if(!placed){
                notPlaced++;
            }
       }
       return notPlaced;
    }
}
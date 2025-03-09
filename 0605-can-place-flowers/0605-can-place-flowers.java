class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int len = flowerbed.length;

        if(len == 1){


            if(flowerbed[0] == 0){

                if(n > 0){
                    n = n - 1;
                }
            }
        }

        if(len >= 2 && flowerbed[0] == 0 && flowerbed[1] == 0){

            if(n > 0){

                n = n - 1;
            }


            flowerbed[0] = 1;
        }
        if(len >= 2 && flowerbed[len - 1] == 0 && flowerbed[len - 2] == 0){

            if(n > 0){

                n = n - 1;
            }

            flowerbed[len - 1] = 1;
        }

        for(int i = 1; i < len - 1; i++){

            if(n == 0){

                return true;
            }

            int left = flowerbed[i - 1];

            int right = flowerbed[i + 1];

            if(flowerbed[i] == 0 && left == 0 && right == 0){

                flowerbed[i] = 1;

                n = n - 1;
            }

            
        }
        return n == 0;
    }
}
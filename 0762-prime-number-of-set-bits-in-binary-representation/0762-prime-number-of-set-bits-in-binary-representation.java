class Solution {

    private boolean isPrime[];
    private void findPrimes(int n){

        int bits = (int)(Math.log(n) / Math.log(2)) + 1;

        isPrime = new boolean[bits+1];

        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i * i <= bits; i++){

            if(isPrime[i]){

                for(int j = i * i; j <= bits; j += i){

                    isPrime[j] = false;
                }
            }
        }

    }
    

    private int findSetBits(int num){

        int cnt = 0;

        while(num != 0){

            num = num & (num - 1);
            cnt++;
        }

        return cnt;
    }
    public int countPrimeSetBits(int left, int right) {

        findPrimes(Math.max(left,right));
        
        int cnt = 0;

        for(int i = left; i <= right; i++){

            int noOfSetBits = findSetBits(i);
            if(isPrime[noOfSetBits]){

                cnt++;
            }
        }

        return cnt;
    }
}
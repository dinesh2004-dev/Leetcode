class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        
        int cnt = numBottles;

        int n = numBottles;

        while(n >= numExchange){

            int newBottles = n / numExchange;

            cnt += newBottles;

            n = newBottles + (n % numExchange);
        }

        return cnt;
    }
}
class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {

        int n = prices.length;
        int half = k / 2;

        long originalProfit = 0;
        for (int i = 0; i < n; i++) {
            originalProfit += (long) strategy[i] * prices[i];
        }

        long[] deltaZero = new long[n];
        long[] deltaOne  = new long[n];

        for (int i = 0; i < n; i++) {
            long old = (long) strategy[i] * prices[i];
            deltaZero[i] = -old;
            deltaOne[i]  = prices[i] - old;
        }

        long[] prefZero = new long[n + 1];
        long[] prefOne  = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefZero[i + 1] = prefZero[i] + deltaZero[i];
            prefOne[i + 1]  = prefOne[i]  + deltaOne[i];
        }

        long maxGain = 0;

      
        for (int start = 0; start + k <= n; start++) {

            int mid = start + half;
            int end = start + k;

            long gain =
                (prefZero[mid] - prefZero[start]) +   
                (prefOne[end]  - prefOne[mid]);

            maxGain = Math.max(maxGain, gain);
        }

        return originalProfit + maxGain;
    }
}

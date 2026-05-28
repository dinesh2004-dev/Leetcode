class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        int[][] pairs = new int[n][2];

        for(int i = 0; i < n; i++){

            pairs[i] = new int[] {efficiency[i], speed[i]};
        }

        Arrays.sort(pairs,(x,y) -> Integer.compare(y[0],x[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long best = 0;
        long totalSpeed = 0;

        for(int[] pair : pairs){

            int spd = pair[1];

            pq.add(spd);

            if(pq.size() <= k){

                totalSpeed += spd;
            }
            else{

                totalSpeed += spd - pq.poll();
            }

            best = Math.max(best,totalSpeed * pair[0]);
        }

        return (int)(best % 1000000007);

        //  int[][] ord = new int[n][2];
        // for (int i = 0; i < n; i++)
        //     ord[i] = new int[] {efficiency[i], speed[i]};
        // Arrays.sort(ord, (a, b) -> Integer.compare(b[0], a[0]));
        // PriorityQueue<Integer> sppq = new PriorityQueue<>();
        // long totalSpeed = 0, best = 0;
        // for (int[] pair : ord) {
        //     int spd = pair[1];
        //     sppq.add(spd);
        //     if (sppq.size() <= k) totalSpeed += spd;
        //     else totalSpeed += spd - sppq.poll();
        //     best = Math.max(best, totalSpeed * pair[0]);
        // }
        // return (int)(best % 1000000007);

        
    }
}
class Solution {
    private long[][] memo = new long[16 * 2 * 11 * 11][2];
    private boolean[] visited = new boolean[16 * 2 * 11 * 11];

    private int encode(int ind, int start, int prev1, int prev2) {
        return ind * (2 * 11 * 11) + start * (11 * 11) + prev1 * 11 + prev2;
    }

    private long[] dfs(int ind, int tight, int start, int prev1, int prev2, String s) {
        if (ind == s.length()) return new long[]{0, 1};

        int key = -1;
        if (tight == 0) {
            key = encode(ind, start, prev1, prev2);
            if (visited[key]) return memo[key];
        }

        long totalWaves = 0;
        long totalCount = 0;
        int limit = tight == 0 ? 9 : s.charAt(ind) - '0';

        for (int d = 0; d <= limit; d++) {
            int nTight = (tight == 1 && d == limit) ? 1 : 0;

            // FIXED: start == 0 means not started yet, so d==0 is a leading zero
            if (start == 0 && d == 0) {
                long[] res1 = dfs(ind + 1, nTight, 0, prev1, prev2, s);
                totalWaves += res1[0];
                totalCount += res1[1];
            } else {
                int nPrev1, nPrev2;
                long add = 0;

                if (start == 0) {
                    // first real digit placed
                    nPrev2 = 10;
                    nPrev1 = d;
                } else {
                    if (prev2 != 10) {
                        boolean peak = (prev1 > prev2 && prev1 > d);
                        boolean valley = (prev1 < prev2 && prev1 < d);
                        if (peak || valley) add = 1;
                    }
                    nPrev2 = prev1;
                    nPrev1 = d;
                }

                long[] res2 = dfs(ind + 1, nTight, 1, nPrev1, nPrev2, s);
                totalWaves += res2[0] + add * res2[1];
                totalCount += res2[1];
            }
        }

        if (key != -1) {
            memo[key][0] = totalWaves;
            memo[key][1] = totalCount;
            visited[key] = true;
        }
        return new long[]{totalWaves, totalCount};
    }

    public long solve(long n) {
        if (n <= 0) return 0;
        visited = new boolean[16 * 2 * 11 * 11];
        String s = String.valueOf(n);
        long[] res = dfs(0, 1, 0, 10, 10, s);
        return res[0];
    }

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }
}
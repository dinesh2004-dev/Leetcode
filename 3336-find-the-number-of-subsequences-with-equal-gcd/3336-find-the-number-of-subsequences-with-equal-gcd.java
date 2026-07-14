class Solution {
    
    int n;
    int nums[];
    int[][] gcdTable;
    int mod = (int) 1e9 + 7;
    long[][][] dp;
    private int gcd(int a,int b){

        while(b != 0){

            int t = b;
            b = a % b;
            a = t;
        }

        return a;
    }
    private long solve(int i,int g1,int g2){

        if(i == n){

            return (g1 != 0 && g1 == g2) ? 1L : 0L;
        }

        if(dp[i][g1][g2] != -1L){

            return dp[i][g1][g2];
        }

        int x = nums[i];

        long ways = solve(i + 1,g1,g2);

        int newG1 = (g1 == 0) ? x : gcdTable[g1][x];

        ways = (ways + solve(i + 1,newG1,g2)) % mod;

        int newG2 = (g2 == 0) ? x : gcdTable[g2][x];

        ways = (ways + solve(i + 1,g1,newG2)) % mod;

        dp[i][g1][g2] = ways;

        return ways;
    }
    public int subsequencePairCount(int[] nums) {
        
        this.n = nums.length;
        this.nums = nums;
        int maxVal = 201;

        gcdTable = new int[maxVal][maxVal];

        for(int a = 0; a < maxVal; a++){

            for(int b = 0; b < maxVal; b++){

                gcdTable[a][b] = gcd(a,b);
            }
        }

        dp = new long[n][maxVal][maxVal];

        for(long[][] d1 : dp){

            for(long[] d2 : d1){

                Arrays.fill(d2,-1L);
            }
        }

        return (int) solve(0,0,0);
    }
}
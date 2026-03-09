class Solution {
    private static int mod = (int) 1e9 + 7;
    private int solve(int zero,int one,int limit,int lastSeen,int consCount,
    int[][][][] dp){

        if(consCount >= limit + 1){

            return 0;
        }
        if(zero == 0 && one == 0){

            return 1;
        }

        if(lastSeen != -1 && dp[zero][one][lastSeen][consCount] != -1){

            return dp[zero][one][lastSeen][consCount];
        }

        
        int left = 0;
        int right = 0;

        

            if(zero > 0){

                int newLast = 0;
                int newCount = (lastSeen == 0) ? consCount + 1 : 1;
                left = solve(zero - 1,one,limit,newLast,newCount,dp);
            }

            if(one > 0){

                int newLast = 1;
                int newCount = (lastSeen == 1) ? consCount + 1 : 1;

                right = solve(zero,one - 1,limit,newLast,newCount,dp);
            }



       int ans = (left + right) % mod;

        if(lastSeen != -1)
            dp[zero][one][lastSeen][consCount] = ans;

        return ans;


    }
    public int numberOfStableArrays(int zero, int one, int limit) {

        int[][][][] dp = new int[zero + 1][one + 1][2][limit + 1];

        for(int[][][] d1 : dp){

            for(int[][] d2 : d1){

                for(int[] d3 : d2){

                    Arrays.fill(d3,-1);
                }
            }
        }
        
        return solve(zero,one,limit,-1,0,dp);
    }
}
class Solution {

    private static int offset = 5000;
    private int solve(int ind,int[] rods,int s1,int s2){

        if(ind == rods.length){

            return (s1 == s2) ? s1 : 0;
        }

        int notPick = solve(ind + 1,rods,s1,s2);
        int pick1 = solve(ind + 1,rods,s1 + rods[ind],s2);
        int pick2 = solve(ind + 1,rods,s1,s2 + rods[ind]);

        return Math.max(notPick,Math.max(pick1,pick2));
    }
    private int solveOptimized(int ind,int[] rods,int diff,int[][] dp){

        if(ind == rods.length){

            return (diff == 0) ? 0 : Integer.MIN_VALUE;
        }

        if(dp[ind][diff + offset] != -1){

            return dp[ind][diff + offset];
        }

        int notPick = solveOptimized(ind + 1,rods,diff,dp);
        int pick1 = rods[ind] + solveOptimized(ind + 1,rods,diff + rods[ind],dp);
        int pick2 = solveOptimized(ind + 1,rods,diff - rods[ind],dp);

        return dp[ind][diff + offset] = Math.max(notPick,Math.max(pick1,pick2));
    }
    public int tallestBillboard(int[] rods) {

        int n = rods.length;

        int[][] dp = new int[n + 1][2 * 5000 + 1];

        for(int[] d : dp){

            Arrays.fill(d,-1);
        }
        
        // return solve(0,rods,0,0);

        return solveOptimized(0,rods,0,dp);
    }
}
class Solution {
    public int lastStoneWeightII(int[] stones) {
        
        int n = stones.length;

        int total = 0;

        for(int stone : stones){

            total = total + stone;
        }

        int target = total / 2;

        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for(int stone : stones){

            for(int tar = target; tar >= 0; tar--){

                boolean notPick = dp[tar];

                boolean pick = false;

                if(tar - stone >= 0){

                    pick = dp[tar - stone];
                }

                dp[tar] = notPick || pick;
            }
        }

        for(int tar = target; tar >= 0; tar--){

            if(dp[tar]){

                return total - (2 * tar);
            }
        }

        return 0;
    }
}
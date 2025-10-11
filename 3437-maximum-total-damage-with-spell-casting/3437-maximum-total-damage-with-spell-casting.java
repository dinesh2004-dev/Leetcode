class Solution {

    private List<Integer> unique;
    private Map<Integer,Long> damageSum;
    private Map<Integer,Long> memo;

    public long maximumTotalDamage(int[] power) {
        
        damageSum = new HashMap<>();

        for(int p : power){

            damageSum.put(p,damageSum.getOrDefault(p,0L)+p);
        }

        unique = new ArrayList<>(damageSum.keySet());

        Collections.sort(unique);

        memo = new HashMap<>();

        return solve(unique.size() - 1);
    }

    public long solve(int i){

        if(i < 0){
            return 0;
        }

        if(memo.containsKey(i)){

            return memo.get(i);
        }

        long notPick = solve(i - 1);

        int j = i - 1;
        int curr = unique.get(i);
         long pick = damageSum.get(curr);

        while(j >= 0 && unique.get(j) >= curr - 2){

            j--;
        }

        pick += solve(j);

        long res = Math.max(pick,notPick);

        memo.put(i,res);

        return res; 
    }
}
class Solution {
    public int[] avoidFlood(int[] rains) {
        
        int n = rains.length;

        Map<Integer,Integer> lakes = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        int ans[] = new int[n];

        for(int i = 0; i < n; i++){

            if(rains[i] == 0){

                dryDays.add(i);
                ans[i] = 1;
            }
            else{

                ans[i] = -1;

                if(lakes.containsKey(rains[i])){

                    Integer dryDay = dryDays.ceiling(lakes.get(rains[i]));
                    if(dryDay == null){

                        return new int[0];
                    }

                    ans[dryDay] = rains[i];
                    dryDays.remove(dryDay);
                }

                lakes.put(rains[i],i);
            }
        }
        return ans;
    }
}